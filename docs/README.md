# User Guide

## Features 
CLI Task management App for users to save in his/her task

### Feature-Task Manager
for single user to record the task that he/she does in future.

-E.g todo task, task with deadlines and upcoming events 

Users will be able to chat with Duke that understand user command and store the task that user had key in.

using following command, todo, deadline, event, delete, find, done, list and bye.

## Usage (Commands are not case sensitive)

### `todo` - Describe action

add a Todo task into both local txt file and task array.

Example of usage: 

`todo assignment 1`

Expected outcome: the Todo task object is stored in the online task array list and offline txt file.

Description of the outcome.

```
Got it. I've added this task:
 [T][ ] assignment 1
Now you have 1 tasks in the list.
```

### `deadline` - Action Describe

add a deadline task with date and time into both local txt file and task array.

Example of usage:

`deadline book /by 30-04-2022 14:00:00`

Expected outcome: the Deadline task object is stored in the online and offline txt file.

Description of the outcome.

```
Got it. I've added this task:
 [D][ ] book (by: Sat Apr 30 14:00:00 CST 2022)
Now you have 2 tasks in the list.
```

### `event` - Action Describe

add a event task with data and time into both local txt file and task array.

Example of usage:

`event project meeting /at 3-06-2021 13:00:00`

Expected outcome: the Event task object is stored in the online and offline txt file.

Description of the outcome.

```
Got it. I've added this task:
 [E][ ]project meeting (at: Thu Jun 03 13:00:00 CST 2021) 
Now you have 3 tasks in the list.
```

### `done` - Action Describe

update the task status by its numbered position in the list.

Example of usage:

`done 3`

Expected outcome: the done status of a task is displayed as 'X' and updated in the database.

Description of the outcome.

```
Nice! I've marked this task as done:
    [E][✘]project meeting (at: Thu Jun 03 13:00:00 CST 2021)
```

### `delete` - Action Describe 

delete a numbered task from both array and txt file. 

Example of usage: 

`keyword (optional arguments)`
`delete 8`

Expected outcome: display task deleted, also deleted from the saved database file permanently.

Description of the outcome. 

```
Noted. I've removed this task:
   [T][✘]read book
Now you have 7 tasks in the list.
```

### `list` - Action Describe

display the task list to user.

Example of usage:

`list`

Expected outcome: showing all tasks as a numbered list.

Description of the outcome.

```
 Here are the tasks in your list: 
	1. [T][✘]read book 
	2. [D][✘]return book (by: Sat Apr 30 14:00:00 CST 2022) 
	3. [E][ ]project meeting (at: Thu Jun 03 13:00:00 CST 2021) 
	4. [T][✘]join sports club 
	5. [T][ ]play game 
	6. [D][ ]stop play (by: Wed Aug 10 11:00:00 CST 2022) 
	7. [D][ ]start work (by: Fri May 13 05:00:00 CST 2022) 
	8. [E][ ]meeting (at: Sun Jun 12 10:00:00 CST 2022)
```

### `find` - Action Describe

find all tasks that contain user input.

Example of usage:

Expected outcome:
`find book`

Expected outcome: display a numbered list of the found tasks, as a read-only list (_no admin functions here_).

Description of the outcome.

```
 Here are the matching tasks in your list: 
	1. [T][✘]read book 
	2. [D][✘]return book (by: Sat Apr 30 14:00:00 CST 2022) 
	3. [T][✘]read book
```

### `bye` - Action Describe

Example of usage:

`bye`

Expected outcome: display bye message to user and exit the App.

Description of the outcome.

```
Bye. Hope to see you again soon!
```