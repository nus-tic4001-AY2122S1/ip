# User Guide  
# Duke Personal Assistant
The Duke program implements an application that
a personal Assistant Chatbot that helps to keep track various of daily items.

## Features 
- [x] Add Todo
- [x] Add Event
- [x] Add Deadline
- [x] Add Event
- [x] Done
- [x] List 
- [x] Exit

### Feature- Add seedu.duke.Command

* Add Todo - tasks without any date/time attached to it
* Add Deadline - tasks that need to be done before a specific date/time
* Add Event - tasks that start at a specific time and ends at a specific time

### Feature- Interact with seedu.duke.Command

* Done - Mark to for different task on the list
* List - List all added tasks
* Exit - Quit the Duke program


## Usage

### `Keyword` - Describe action

Describe the action and its outcome.

Example of usage: 

* `todo <borrow book>`
* `deadline <return book /by Sunday>`
* `event <project meeting /at Mon 2-4pm>`

* `list`
* `done 1`
* `bye`

Expected outcome:

**todo borrow book**
```
-------------------------------
    Got it. I've added this task:
    borrow book
-------------------------------
    Now you have 0 tasks in the list.
```
    
**event project meeting /at Mon 2-4pm**
```  
-------------------------------
    Got it. I've added this task:
    project meeting /at Mon 2-4pm
-------------------------------
    Now you have 0 tasks in the list.
```
    
**list**
```
Here are the TaskPackage.seedu.duke.Command in your list:
    1. [✘][T]borrow book
    2. [✘][E] project meeting (at: Mon 2-4pm)
```
    
**done 1**
```
-------------------------------
    Nice! I've marked this task as done:
    [✓][E] project meeting (at: Mon 2-4pm)
```
    
**bye**
```
-------------------------------
Bye. Hope to see you again soon!
```
