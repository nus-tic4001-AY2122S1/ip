# User Guide

## Features 

### Feature: Add/Edit/Delete different type of Tasks.

- Such Tasks include:
  - simple ToDos 
  - date specific Events
  - critical Deadlines


### Feature: Able to import and export your current Tasklist using a standard .txt file

- Just put the duke.txt in the `/data` subfolder!

## Usage

### `list` - Lists the current list of tasks available

Quite self-explanatory. 

Example of usage: 

`list`

Expected outcome:

Lists the current list of tasks available

```
1: [T][❌] dance
2: [T][❌] study
```

### `delete` - Deletes task at the specified index.

Quite self-explanatory.

Example of usage:

`delete 1`

Expected outcome:

Removes the task from the list and `/data/duke.txt`

```
Noted. I've removed this task:
 [T][❌] dance
```

### `todo` - Adds a To-Do Task.

Adds a todo task of a specific description.

Example of usage:

`todo desc`

Expected outcome:

Very straight forward. New task is added.

```
todo study
Got it. I've added this task:
[T][❌] study
```