# User Guide

## Features 

### Feature - List

`list`: Lists all tasks in the task list.

### Feature - Add Tasks

1. `todo task`: Adds todo task to the task list.
2. `deadline task /by date`: Adds deadline task to the task list.
3. `event task /at date`: Adds event task to the task list.

### Feature - Mark as Done

`done 1`: Mark the first (1) task in the task list as done.

### Feature - Delete Task

`delete 1`: Delete the first (1) task from the task list.

### Feature - Terminate

`exit` or `bye`: To terminate the program


## Usage

`list`

Expected outcome:
All tasks in the task list are listed.

```
1.[T][✘] read book
2.[D][✘] read (by: 2021-09-01)
3.[E][✘] movie (at: 2021-02-9)
4.[T][✘] read
5.[E][✘] movie (at: 2021-09-01)
```

`todo task`

Expected outcome:
A todo task named 'task' is added to the task list.

```
Got it. I've added this task:
[T][✘] task
Now you have 6 tasks in the list.
```

`todo task`

Expected outcome:
A task named 'task' is added to the task list.

```
Got it. I've added this task:
[T][✘] task
Now you have 6 tasks in the list.
```

`deadline task /by 2021-09-26`

Expected outcome:
A deadline task named 'task' is added to the task list.

```
Got it. I've added this task:
[D][✘] task (by: 2021-09-26)
Now you have 7 tasks in the list.
```

`event task /at 2021-09-26`

Expected outcome:
An event task named 'task' is added to the task list.

```
Got it. I've added this task:
[E][✘] task (at: 2021-09-26)
Now you have 8 tasks in the list.
```

`done 1`

Expected outcome:
Mark the first task as done.

```
Nice! I've marked this task as done: 
[T][✓] read book
```

`delete 1`

Expected outcome:
The first task is deleted.

```
Noted. I've removed this task:
[T][✓] read book
Now you have 7 tasks in the list.
```


`exit` or `bye`

Expected outcome:
The duke program is terminated. 

```
Bye. Hope to see you again soon!
___________________________________________
```
