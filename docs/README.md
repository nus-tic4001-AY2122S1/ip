# User Guide

## Features

An Online CLI-type App for users who can type fast on their keyboards!

### Feature-An easy to use Task Manager

A callable online store and point-of-contact for a single user to register in the tasks that he/she often does.

- E.g. todo, deadlines and events tasks.

### Feature A Lively ChatBot Service

User will be able to chat with LisGenie, the funny ChatBot, who helps in the tasks parsing, creation, storage and admin.

- Admin tasks include IO errors recovery via backup file, `done`, `delete`, `find`, `list`, `bye` commands, among
  others.
- User will be advised if the database is full, to delete some old records before use for optimal performance.

## Usage <all commands in lowercase>

### `bye` - Action Describe

exit the LisGenie App.

Example of usage:

`bye`

Expected outcome: display bye message to user.

Description of the outcome.

```
Bye. Hope to see you again soon!
```

### `list` - Action Describe

display the task database to user.

Example of usage:

`list`

Expected outcome: showing all tasks as a numbered list.

Description of the outcome.

```
 7.[T][X] borrow a book
 8.[D][ ] submit the TIC4001 UG (by: Oct 1 2021)
 9.[E][ ] attend a meeting (at: Fri 2 - 3.30pm)
10.[E][X] attend another meeting (at: Dec 2 2021)
```

### `delete` - Action Describe

delete a numbered task from the online database list.

Example of usage:

`delete 7`

Expected outcome: display task deleted, also deleted from the saved database file permanently.

Description of the outcome.

```
Noted. I've removed this task:
  [T][X] borrow a book
Now you have 11 tasks in the list.
```

### `find` - Action Describe

find all tasks that contain a word inputted by the user.

Example of usage:

`find book`

Expected outcome: display a numbered list of the found tasks, as a read-only list (_no admin functions here_).

Description of the outcome.

```
Here are the matching tasks in your list:
1.[D][X] return book (by: June 6th)
2.[T][ ] borrow another book
```

### `done` - Action Describe

update the done status of a task by its numbered position in the list.

Example of usage:

`done 3`

Expected outcome: the done status of a task is displayed as 'X' and updated in the database.

Description of the outcome.

```
Here are the matching tasks in your list:
1.[D][X] return book (by: June 6th)
2.[T][ ] borrow another book
```

### `todo` - Action Describe

add a Todo task into the database.

Example of usage:

`todo borrow another book`

Expected outcome: the Todo task object is stored in the online and offline database register.

Description of the outcome.

```
Got it. I've added this task:
 [T][ ] borrow another book
Now you have 11 tasks in the list.
```

### `deadline` - Action Describe

add a Deadline task into the database.

Example of usage:

`deadline attend the Maths Quiz /by 2021-10-6`

Expected outcome: the Deadline task object is stored in the online and offline database register.

Description of the outcome.

```
Got it. I've added this task:
 [D][ ] attend the Maths Quiz (by: Oct 6 2021)
Now you have 12 tasks in the list.
```

### `event` - Action Describe

add a Event task into the database.

Example of usage:

`event attend exhibition Expo@Changi venue /at 2-4:30pm Fri`

Expected outcome: the Event task object is stored in the online and offline database register.

Description of the outcome.

```
Got it. I've added this task:
 [E][ ] attend exhibition Expo@Changi venue (at: 2-4:30pm Fri)
Now you have 13 tasks in the list.
```

# **

NB**: - dates, if used, must be the sole entry entered after `/by` or `/at`, entered as yyyy-MM-dd or yyyy/MM/dd, to be
parsed correctly.
