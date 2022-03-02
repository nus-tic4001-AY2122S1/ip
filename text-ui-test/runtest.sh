#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

if [ -e "./data/duke.txt" ]
then
    rm data/duke.txt
fi

# compile the code into the bin folder, terminates if error occurred
if ! javac -Xlint:none -d ../out/production/ip ../src/main/java/duke/*.java ../src/main/java/duke/ui/* ../src/main/java/duke/storage/* ../src/main/java/duke/exception/* ../src/main/java/duke/parse/* ../src/main/java/duke/task/* ../src/main/java/duke/command/*
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ../out/production/ip/ duke.Duke < input.txt > ACTUAL.TXT

# convert to UNIX format
# cp EXPECTED.TXT EXPECTED-UNIX.TXT
# dos2unix ACTUAL.TXT EXPECTED-UNIX.TXT

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED.TXT
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    exit 0
else
    echo "Test result: FAILED"
    exit 1
fi
