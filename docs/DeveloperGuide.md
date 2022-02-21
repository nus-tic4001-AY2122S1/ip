# Developer Guide

## Acknowledgements

[https://se-education.org/](https://se-education.org/)

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

# Design
The Design consist of different classes and component like Ui, Storage, Parser, TaskList, MainWindow and Duke.

### Sequence Diagram
The Sequence Diagram below shows how the components interact with each other for the scenario where the user executes the command `add` and `save` tasks.

![SequenceDiagram](https://user-images.githubusercontent.com/54068363/154961557-5c8eb8d9-6d45-4195-ab59-7e3db230af3b.png)
* The user executes add todo task command
* Duke calls Parser to parse user input and return Command
* Duke calls Command to execute add task
* The user proceed to save tasks to file

### Object Diagram
![ObjectDiagram](https://user-images.githubusercontent.com/54068363/154961981-561df54b-ae8d-491b-a5f5-8378b2fda7e0.png)

## Appendix: Requirements

### Product scope

**Target user profile**
* has a need to manage and track tasks
* prefers desktop apps over other types
* prefers typing to mouse interactions
* is reasonably comfortably using CLI apps and GUI apps

**Value proposition**
* keep record of task(s) (todo, deadline, and event task)
* find task(s) easily and clearly
* easy to remove task

## User Stories

|Version| As a ... | I want to ... | So that ...|
|--------|----------|---------------|------------------|
|v1.0|new user|know how to add a task |I can record the task to track|
|v1.0|new user|know how to delete task(s) |I can remove tasks that I do not have to keep track anymore|
|v1.0|new user|view the list of task |I can see all my tasks|
|v1.0|new user|mark task(s) as done |I can keep track of the status of my tasks|
|v1.5|semi-new user|save my tasks to file|I can track my tasks everyday|
|v2.0|user|find all tasks of a specific task type|I can easily check for the information I need|
|v2.0|user|find all tasks based on date range |I can easily check the tasks that needs to be completed within the date range|
|v3.0|user|have a GUI instead of CLI |it is more user friendly|
|v3.0|user|sort tasks based on task types |I will not miss anything out|

### Use Cases

(For all use cases below, the **System** is ```Duke``` and the **Actor** is the ```user```, unless specified otherwise)

**Use case: Add Task**
1. User input task details
2. Duke records the task
3. Duke shows the task added successfully
4. User save updated task list to file

**Use case: Delete Task(s)**
1. User requests to delete task(s)
2. Duke deletes the task(s) from the list
3. Duke shows the task deleted successfully
4. User save updated task list to file

**Use case: List Tasks**
1. User requests to view all tasks 
2. Duke shows the list of tasks

**Use case: Find Tasks**
1. User keys in the keyword to search (e,g date range, task types)
2. Duke performs searching
3. Duke shows the filtered list of tasks

**Use case: Sort Tasks**
1. User requests to sort all tasks 
2. Duke performs sorting based on task types
3. Duke shows the sorted list of tasks

### Non-Functional Requirements

* Each request should be processed within 3 seconds.
* Should work on any mainstream OS as long as it has Java 11 or above installed.
* The command should be easy to understand and to use.
* Program should be easily add in new function or new modules.

## Glossary

* Mainstream OS: Windows, Linux, Unix, OS-X
* CLI - Command Line Interface
* GUI - Graphical User Interface