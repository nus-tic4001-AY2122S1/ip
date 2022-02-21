# User Guide

## Introduction

Duke frees your mind of having to remember things you need to do. It's,

- text-based
- easy to learn
- ~~FAST~~ SUPER FAST to use


## Quick Start


1. Ensure that you have Java 11 or above installed.
2. download it from [here](https://github.com/IcyNoPeople/ip).
3. double-click it.
4. add your tasks.
5. let it manage your tasks for you 😉

## Features 

### Tracking and managing of Task

Duke will help you to track and manage your tasks with ease. Tasks could be group into ToDos, Events or Deadlines.
<img src=UserGuide_image/TrackAndManage.PNG width="400">

### Storing of task

Duke will save your task such that when you start up Duke the next time, your saved task will appear.
<img src=UserGuide_image/StoringOfTask.PNG width="400">

### Finding of your task

Duke will help and find and return a list of task using keywords which you would like to find.
<img src=UserGuide_image/FindingStudy.PNG width="400">

### Inform duplicate task

Duke will inform you if you add another task with the same description as an existing one.
<img src=UserGuide_image/duplicate.PNG width="400">


### List of command available
Here are a list of commands you can enter, and the explanations of what the commands do:

| Command               | Description                                                                                                                               |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| hi                    | Say hi to Duke                                                                                                  |
| todo                  | Add a new to-do task to the list.                                                                                                 |
| event                 | Add an event task to the list. |
| deadline              | add a deadline task to the list.                                  |
| list                  | List all your current task.          |
| find                  | Find a task.                  |
| done                  | Saves your current personal list.                                                                                                         |
| delete                | Find a task.                                                                                                           |
| clearlist             | Delete all your current task in the list.                                                                                                                 |
| exit/bye/quit         | Closing the app.                  |
| help                  | Show a list of commands.                  |

## Usage

### `Todo` - Add a new to-do task to the list

By typing your command with your task and date, your Todo will be saved to the list and Duke will informed you that it has been added

Example of usage:

`Todo (task description)`

Expected outcome:

The arguments will be saved to list.

```
Type something: Todo assignment1
--------------------------------
Added: [T] [ ] assignment1
Now you have 1 tasks in the list.
```

### `Event` - add an event task to the list

By typing your command with your task and date, your event will be saved to the list and Duke will informed you that it has been added

Example of usage:

`Event (task description) /at (yyyy-mm-dd)`

Expected outcome:

The arguments will be saved to list.

```
Type something: Event Dinner and Dance /at 2021-09-23
--------------------------------
Added: [E] [ ] Dinner and Dance (at: Sep 23 2021)
Now you have 2 tasks in the list.
```

### `Deadline` - add a deadline task to the list

By typing your command with your task and date, your deadline will be saved to the list and Duke will informed you that it has been added.

Example of usage:

`Deadline (task description) /by (yyyy-mm-dd)`

Expected outcome:

The arguments will be saved to list.

```
Type something: Deadline school fees /by 2021-09-24
--------------------------------
Added: [D] [ ] school fees (by: Sep 24 2021)
Now you have 3 tasks in the list.
```

### `list` - Describe action

By typing the command, A list of your task will appear.

Example of usage:

`List`

Expected outcome:

A list of your task will appear.

```
Type something: List
--------------------------------
Task Number 1: [T] [ ] assignment1
Task Number 2: [E] [ ] Dinner and Dance (at: Sep 23 2021)
Task Number 3: [D] [ ] school fees (by: Sep 24 2021)
```

### `Find` - Find a task

Find a task using the command

Example of usage:

`Find (keyword)`

Expected outcome:

A list of task with the keyword will appear

```
Type something: find Dance
--------------------------------
Task Number 1: [E] [ ] Dinner and Dance (at: Sep 23 2021)
```

### `Done` - Mark a task as done

Mark a task as done using the command and task number and duke will mark it as done.

Example of usage:

`Done (task number)`

Expected outcome:

Task is being mark as done.

```
Type something: Done 1
--------------------------------
Nice! I've marked this task as done: 
Task Number 1: [T] [X] assignment1
```

### `Delete` - Delete a task

Delete a task from the list by using the Delete command

Example of usage:

`Delete (task number)`

Expected outcome:

A task will be removed from the list

```
Type something: delete 1
--------------------------------
I have deleted the following: 
[T] [X] assignment1
Now you have 2 tasks in the list.
```

### `ClearList` - Delete all your current task in the list

Delete all your current task in the list by using the ClearList command

Example of usage:

`ClearList`

Expected outcome:

All task will be removed from the list

```
Type something: clearlist
--------------------------------
List of Task has all been cleared, you have an empty list now.
```


### `Exit`/`bye`/`quit` - Closing the app

Say goodbye to Duke and close the app.

Example of usage:

`Bye`

Expected outcome:

The app will close

```
Type something: Bye
--------------------------------
Bye. Hope to see you again soon!
Closing in 10 sec
Closing in 9 sec
Closing in 8 sec
Closing in 7 sec
Closing in 6 sec
Closing in 5 sec
Closing in 4 sec
Closing in 3 sec
Closing in 2 sec
Closing in 1 sec

```




### `Help` - Show a list of commands

Show a list of commands and give a brief explaination on using

Example of usage:

`help`

Expected outcome:

The list of command will appear

```
Type something: help
--------------------------------
List of command that Duke have: 
(*Command are not case sensitive)
(**Words with double * are case sensitive)

"Hi": Say hello to the bot
How to use: 
Type Hi
E.g. Type something: Hi

"Bye" OR "Exit" OR "Quit": Say goodbye to the bot and close the program
How to use: 
Type Bye
E.g. Type something: Bye

"Todo": Set a task that you want to do
How to use: 
Type Todo (Your To Do Task)
E.g. Type something: Todo Get a pet

"Event": Set a event task
How to use: 
Type Event (Your event Task) /at (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) (Optional: hh:mm OR hhmm <24 Hours format>) 
E.g. Type something: Event Countdown party /at 2019/12/31
Type something: Event Basketball /at Wed 18:00 

"Deadline": Set a deadline task
How to use: 
Type Deadline (Your event Task) /by (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) (Optional: hh:mm OR hhmm <24 Hours format>)
E.g. Type something: Deadline Duke project /by 2019/11/17 2359 
Type something: Deadline Pay phone bills /by Sat

"List": Bring out the list of task
How to use: 
Type List
E.g. Type something: list

"Find": Find a task with the word you want to find
How to use: 
Type Find (The word**)
E.g. Type something: Find bill

"Done": Set a task to Done
How to use: 
Type Done (Task Number)
E.g. Type something: Done 5

"Delete": Delete a task(Be careful: Once you delete a task, it is gone forever. And all other task number changes) 
How to use: 
Type Delete (Task Number)
E.g. Type something: Delete 5

"Clearlist": Clear and remove all the task in the task list
*Note: Clearlist will not save until you add another task, so if you want to undo your clear, restart the program
How to use: 
Type Clearlist
E.g. Type something: Clearlist

"Help": Since you just used this, I'm sure I don't have to explain this...
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Just follow the step below:
1. Just copy the txt file in the data folder from the current computer. 
2. Create a data folder in the same path as the executable file in the other computer.
3. Put the txt file there. 


