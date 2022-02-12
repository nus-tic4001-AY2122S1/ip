# User Guide

DukePro is a **desktop app for managing tasks, optimized for use via a Command Line Interface (CLI)**.

## Quick Start

1. Ensure you have Java **11** or above installed in your computer.
2. Download the latest ```ip.jar``` from [here](https://github.com/zyjarvis/ip/releases).
3. Copy the file to the folder you want to use as the root folder for your DukePro.
4. Create an empty folder name ```data``` in the same folder.
5. Create an empty text file name  ```duke.txt``` inside the ```data``` folder.
6. Open Command Prompt.
7. Type ```cd [project_root]``` to set project root and type ```java -jar ip.jar``` to run the app.
8. Type the commands to manage the tasks. Some example commands you can try:
* ```todo borrow book```: Add todo task ```borrow book``` to the task list.
* ```deadline return book /by 02-12-2021```: Add deadline ```deadline return book (by 02-12-2021)``` to the task list.
* ```event project meeting /at 02-12-2021```: Add event  ```project meeting (at Dec 02 2021)``` to the task list.
* ```list```: List all tasks.
* ```done 2```: Mark the 2nd task as done.
* ```delete 2```: delete the 2nd task in the list.
* ```find book```: search the task with keyword of ```book```.
* ```bye ```: Exits the app.
9. Refer to the **Features** below for details of each command.

## Features

**Words in UPPER_CASE are the parameters to be supplied by the user.**

### Add todo: ```todo```

Add a todo task to the DukePro task list.

Format: ```todo DESCRIPTION```
* The ```DESCRIPTION``` is the detail of the task.
* The ```DESCRIPTION``` cannot be empty.

Example:
* ```todo borrow book ```

### Add an deadline: ```deadline```

Add a deadline to the DukePro task list.

Format: ```deadline DESCRIPTION /by DATE```
* The ```DESCRIPTION``` is the detail of the event.
* The ```DATE``` must be in ```DD-MM-YYYY``` format.
* Use ```/by``` between ```DESCRIPTION``` and ```DATE```
* The ```DESCRIPTION``` and ```DATE``` cannot be empty.

Example: ```deadline return book /by 02-12-2021```

### Add an event: ```event```

Add an event to the DukePro task list.

Format: ```event DESCRIPTION /at DATE```
* The ```DESCRIPTION``` is the detail of the event.
* The ```DATE``` must be in ```DD-MM-YYYY``` format.
* Use ```/at``` between ```DESCRIPTION``` and ```DATE```
* The ```DESCRIPTION``` and ```DATE``` cannot be empty.

Example: ```event meeting /at 02-12-2021```

### Display tasks: ```list```

Display all the tasks in the list.

Format: ```list```

Example: ```list```

### Mark as done: ```done```

Mark a task as done.

Format: ```done INDEX```
* Mark the task as done at the specified ```INDEX```. The index refers to the index number shown in the task list.
* The index **must be a positive integer** 1, 2, 3, ...
* The index cannot be empty.

Example: ```done 2```

### Delete a task: ```delete```

Delete a task in the list.

Format: ```delete INDEX```
* Delete the task at the specified ```INDEX```. The index refers to the index number shown in the task list.
* The index **must be a positive integer** 1, 2, 3, ...
* The index cannot be empty.

Example: ```delete 2```

### Search tasks: ```find```

Search the task with the keyword. 

Format: ```find KEYWORD```
* The ```KEYWORD``` is the keyword to search.
* The ```KEYWORD``` cannot be empty.

Example:
* ```find book```

### Exit the program: ```bye```

Exit the program.

Format: ```bye```

Example: ```bye```

### Save the data

ProDuke data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Edit the data file

ProDuke data are saved as a txt file ```[project_root]/data/duke.txt```. Advanced users are welcome to update data directly by editing that data file.

## FAQ

**Q**: How do I transfer my data to another Computer?

**A**: Without running the program, just copy the ```tasks.txt``` in the ```data``` folder.
To run and show the data in another computer, you need to follow the ```Quick Start``` above, and copy the ```tasks.txt``` to the ```data``` folder.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**Todo** | ```todo DESCRIPTION``` e.g.,```todo borrow book```
**Deadline** | ```deadline DESCRIPTION /by DATE``` e.g., ```deadline return book /by 02-12-2021```
**Event** | ```event DESCRIPTION /at event DESCRIPTION /at DATE``` e.g., ```event meeting /at 02-12-2021```
**List** | ```list``` e.g., ```list```
**Done** | ```done INDEX``` e.g., ```done 2```
**Delete** | ```delete INDEX``` e.g., ```delete 2```
**find** | ```find KEYWORD``` e.g., ```find book```
**Bye** | ```bye``` e.g., ```bye```
