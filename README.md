# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are
instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project
   first)
1. Open the project into Intellij as follows:
    1. Click `Open`.
    1. Select the project directory, and click `OK`.
    1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 11** (not other versions) as explained
   in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()` (if the code
   editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the
   below as the output:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   
   Hello! I'm LisGenie
   What can I do for you?
   
   MasterOm :
   ```

## Running from a jar file

**Run the jar file in the following way only:**

- Download the ip.jar file from [here](https://github.com/gweeyc/ip/releases/tag/v1.0)
- Copy the jar file into an empty folder
- Open a command window in that folder

Run the command java -jar `{filename}.jar`, e.g. java -jar `ip.jar` (i.e., run the command in the same folder as the jar
file)

***

#### Supported CLI Commands (all lowercase)

* bye - exit the LisGenie App
* list - display the list of all tasks
* delete `<integer>` - delete a numbered task from the displayed database list: e.g. delete 3
* done `<integer>` - update the done status of a task according to its number in the displayed database list: done 9
* find `<text>` - list tasks that contain a certain word: e.g. find book
* todo `<text>` - add a Todo task to the database: e.g. todo read a magazine
* deadline `<text></by><text>` - add a Deadline task to the database: e.g. deadline submit the Maths assignment /by Fri
  3pm
* event - similar to deadline except </at> is substituted for </by>: e.g. event attend ExhibitA01@WTC, Fri 2-4:30pm /at
  2021-11-15 _(or use format: 2021/11/15)_

# **

NB**: - dates, if used, must be the sole entry entered after `/by` or `/at`, entered as yyyy-MM-dd or yyyy/MM/dd, to be
parsed correctly.

