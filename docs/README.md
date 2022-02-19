# User Guide

## Features 

### Adds a todo/event/deadline task

Adds a todo/event/deadline task to the current tasklist

### Marks a todo/event/deadline task(s) as done

Marks a todo/event/deadline task(s) as done to the current tasklist

### Deletes todo/event/deadline task(s)

Deletes todo/event/deadline task(s) to the current tasklist

### Lists all tasks

Lists all the tasks in the current tasklist

### Finds todo/event/deadline task(s) using task type and date range

Finds todo/event/deadline task(s) using task type and date range in the current tasklist

### Saves all tasks

Saves all the tasks in the current tasklist to Duke.txt file

### Exit programme

Exit Duke

## Usage


### `todo <description>` - Adds a todo task

Adds a todo task to the current tasklist

Example of usage: 

`todo report`

Expected outcome:

```
____________________________________________________________
 Got it. I've added this task:
  [T][ ] report
 Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `event <description> /at <date>` - Adds an event task with date

Adds an event task with date to the current tasklist

Example of usage: 

`event wedding /at 2 aug 2021`

Expected outcome:

```
____________________________________________________________
 Got it. I've added this task:
  [E][ ] wedding (at: 02 Aug 2021)
 Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `event <description>` - Adds an event task without date

Adds an event task without date to the current tasklist

Example of usage: 

`event exhibition`

Expected outcome:

```
____________________________________________________________
 Got it. I've added this task:
  [E][ ] exhibition (at: Date not specified)
 Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `deadline <description> /by <date>` - Adds a deadline task with date

Adds a deadline task with date to the current tasklist

Example of usage: 

`deadline assignment /by 12 sep 2021`


Expected outcome:

```
____________________________________________________________
 Got it. I've added this task:
  [D][ ] assignment (by: 12 Sep 2021)
 Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `deadline <description>` - Adds a deadline task without date

Adds a deadline task without date to the current tasklist

Example of usage: 

`deadline bills`

Expected outcome:

```
____________________________________________________________
     Got it. I've added this task:
      [D][ ] bills (by: Date not specified)
     Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `done <index>` - Marks a todo/event/deadline task(s) as done

Marks a todo/event/deadline task(s) as done to the current tasklist

Example of usage: 

`done 1,2`

Expected outcome:

```
____________________________________________________________
 Nice! I've marked this task(s) as done:
  [T][X] report
  [E][X] wedding (at: 02 Aug 2021)
____________________________________________________________
```

### `delete <index>` - Deletes todo/event/deadline task(s)

Deletes todo/event/deadline task(s) in the current tasklist

Example of usage: 

`delete 1,2`

Expected outcome:

```
____________________________________________________________
 Noted. I've removed this task:
  [T][X] report
  [E][X] wedding (at: 02 Aug 2021)
 Now you have <numberOfTasks> tasks in the list.
____________________________________________________________
```

### `list` - Lists all task(s)

Lists all task(s) in the current tasklist

Example of usage: 

`list`

Expected outcome:

```
____________________________________________________________
 Here are the tasks in your list:
 1. [D][ ] assignment (by: 12 Sep 2021)
 2. [D][ ] presentation (by: 01 Dec 2021)
 3. [T][ ] fetch mum
 4. [E][ ] meeting (at: 08 Jun 2021)
 5. [E][ ] workshop (at: 17 Jul 2021)
 6. [D][ ] bills (by: Date not specified)
 7. [E][ ] exhibition (at: Date not specified)
____________________________________________________________
```
### `find all <tasks>` - Finds all todo/event/deadline task(s)

Finds todo/event/deadline task(s) in the current tasklist

Example of usage: 

`find all event`

Expected outcome:

```
____________________________________________________________
 Here are the tasks in your list:
 1. [E][ ] meeting (at: 08 Jun 2021)
 2. [E][ ] workshop (at: 17 Jul 2021)
 3. [E][ ] exhibition (at: Date not specified)
____________________________________________________________
```

### `find <tasks> on <date>` - Finds todo/event/deadline task(s) based on date 

Finds todo/event/deadline task(s) based on date in the current tasklist

Example of usage: 

`find event on 8 jun 2021`

Expected outcome:

```
____________________________________________________________
 Here are the tasks in your list:
 1. [E][ ] meeting (at: 08 Jun 2021)
____________________________________________________________
```

### `find <tasks> from <date>` - Finds todo/event/deadline task(s) based on from date 

Finds todo/event/deadline task(s) based on from date in the current tasklist

Example of usage: 

`find event from 1 jul 2021`

Expected outcome:

```
____________________________________________________________
 Here are the tasks in your list:
 1. [E][ ] workshop (at: 17 Jul 2021)
____________________________________________________________
```

### `find <tasks> between <date> to <date>` - Finds todo/event/deadline task(s) based on date range

Finds todo/event/deadline task(s) based on date range in the current tasklist

Example of usage: 

`find event between 1 apr 2021 to 20 jun 2021`

Expected outcome:

```
____________________________________________________________
 Here are the tasks in your list:
 1. [E][ ] meeting (at: 08 Jun 2021)
____________________________________________________________
```

### `save` - Saves all task(s)

Saves all task(s) in the current tasklist

Example of usage: 

`save`

Expected outcome:

```
____________________________________________________________
 Tasks saved!
____________________________________________________________
```

### `bye` - Exit programme

Exit Duke

Example of usage: 

`bye`

Expected outcome:

```
____________________________________________________________
 Bye. Hope to see you again soon!
____________________________________________________________
```
