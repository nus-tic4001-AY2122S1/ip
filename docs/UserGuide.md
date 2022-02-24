# User Guide

## Introduction

Duke is a task tracker specifically built for computing students that are comfortable with the CLI.
Working on improving and adding features to the existing Duke project and making it useful for students to manage their schedule and work.
Natural language will be implemented to avoid exceptions due to typing errors.

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](https://github.com/thisisdax/ip).

## Features

{Give detailed description of each feature}

### Adding a todo: `todo`

Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

- The `DEADLINE` can be in a natural language format.
- The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Appointment

#### Adding an appointment: `appointment`

Adds a new item to the list of todo items, the task is type of Appointment task which has additional `at` and `location`
fields.

Format: `appointment {description} /at {date time} /l {location}`

Example of usage:

`appointment see doctor /at 2021-10-21 1:30:00 pm /l Changi`

`appointment see doctor /at next-tues 1:30:00 pm /l Changi`

#### Setting an appointment time: `set_time`

Update existing appointment time

Format: `set_time {task number} {date time}`

Example of usage:

`set_time 2 2021-10-21 1:30:00 pm`

`set_time 2 next-tues 1:30:00 pm`

NOTE: This is list of possible format the `data time` field can accept (case-insensitive):

- "22-09-2018 1:23:43 pm"
- "TODAY 1:23:43 pm"
- "YESTERDAY 1:23:43 pm"
- "TOMORROW 1:23:43 pm"
- "THIS-MON 1:23:43 pm"
- "THIS-TUE 1:23:43 pm"
- "THIS-WED 1:23:43 pm"
- "THIS-THU 1:23:43 pm"
- "THIS-FRI 1:23:43 pm"
- "THIS-SAT 1:23:43 pm"
- "THIS-SUN 1:23:43 pm"
- "NEXT-MON 1:23:43 pm"
- "NEXT-TUE 1:23:43 pm"
- "NEXT-WED 1:23:43 pm"
- "NEXT-THU 1:23:43 pm"
- "NEXT-FRI 1:23:43 pm"
- "NEXT-SAT 1:23:43 pm"
- "NEXT-SUN 1:23:43 pm";

#### Setting an appointment location: `set_location`

Update existing appointment location

Format: `set_location {task number} {location}`

Example of usage:

`set_location 2 Bedok`

### TaskProgress: `progress`

Check existing tasks progress, how many tasks have been completed.

Format: `progress`

Example of usage:

`progress`

### Bye: `bye`

To exit the program

Format: `bye`

### Search Tasks by Date: `search`

Search tasks that have the same date as the given user input.

Format: `search --date {date format}`

Example of usage:

`search --date 22-09-2018`

`search --date this-mon`

NOTE: the date format is same as the setting Appointment date format.

### Categories

#### Add Categories: `categories add`
Adds a new item to the list of categories.

Format: `categories add {CATEGORY_NAME}`

Example of usage:
`categories add fishes`

#### Remove Categories: `categories delete`
Removes an existing item in the current list of categories.

Format: `categories delete {CATEGORY_NUMBER}`

* The `CATEGORY_NUMBER` must be an integer within the category list and it cannot be 0.

Example of usage:
`categories delete 1`

#### View Categories: `categories view`
Prints the current list of existing categories.

Format: `categories view`

Example of usage:
`categories view`

#### Tag Categories: `categories tag`
Tag an existing category to a task.

Format: `categories tag {TASK_NUMBER} {CATEGORY_NAME}`

* The `TASK_NUMBER` must be an integer within the category list and it cannot be 0.

Example of usage:
`categories tag 1 fishes`

### Search

#### Search Tasks by Category Tag: search
Filters and prints a task list that contains a specific `category tag`

Format: `search {CATEGORY_TAG}`

Example of usage: `search NUS Year 4 Sem 1`

#### Search Tasks by Task Type: `search`
Filters and prints a task list that contains a specific task type (i.e. appointment or todo)

Format: `search appointment` or `search todo`

#### Search Tasks by Date: `search`
Filters and prints a task list of appointments with specified date

Format: `search {date}`

* Date format has to be "dd-MM-yyyy"

Example of usage: `search 13-11-2021`


#### Search Tasks by Description: `search`
Filters and prints a task list that contains the specified keywords

Format: `search {keyword(s)}`

* Order of `{keyword(s)}` matters

Example of usage: `search exams 2021`





## FAQ

**Q**: How do I transfer my data to another computer?

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

- Add todo `todo n/TODO_NAME d/DEADLINE`
- Add Appointment `appointment`
- Set Appointment date time `set_time`
- Set Appointment location `set_location`
- Check task progress `progress`
- Search for tasks by date `search --date`
- Add category `categories add {CATEGORY_NAME}`
- Delete category `categories delete {CATEGORY_NUMBER}`
- View category `categories view`
- Tag category `categories tag {TASK_NUMBER} {CATEGORY_NAME}`
- Search Tasks by Category Tag `search {CATEGORY_TAG}`
- Search Tasks by Task Type `search appointment` or `search todo`
- Search Tasks by Date `search {date}` where date format is "dd-MM-yyyy"
- Search Tasks by Description `search {keyword(s)`