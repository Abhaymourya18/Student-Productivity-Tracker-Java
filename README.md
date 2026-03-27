# Student Productivity Tracker (Java)

## Overview

This project is a Java-based desktop application designed to help students manage daily tasks and monitor their productivity. It was developed as part of a Bring Your Own Project (BYOP) assignment, with the goal of solving a common real-world problem: maintaining consistency and organization in daily academic work.

The application allows users to create accounts, manage tasks, and track their progress over time through a simple and user-friendly graphical interface.

---

## Problem Statement

Many students struggle with:

* Keeping track of tasks and deadlines
* Maintaining consistency in their work
* Understanding how productive they actually are

This project addresses these issues by providing a structured system for task management and performance tracking.

---

## Features

### User Authentication

* Signup and login functionality
* Multiple users supported
* Each user has separate task data

### Task Management

* Add new tasks
* Delete existing tasks
* Mark tasks as completed

### Priority System

* Assign priority levels: High, Medium, Low

### Streak Tracking

* Tracks task completion activity
* Encourages consistency in work

### Productivity Statistics

* Displays total tasks
* Completed and pending tasks
* Calculates productivity percentage

### Data Persistence

* Tasks and user data are stored using file handling
* Data is retained between sessions

### Graphical User Interface

* Built using Java Swing
* Includes login screen and task dashboard
* Simple and structured layout

---

## Technologies Used

* Java (Core Java and Object-Oriented Programming)
* Java Swing (GUI development)
* File Handling (data storage)

---

## Project Structure

```text
project/
│
├── Main.java
├── LoginGUI.java
├── TaskGUI.java
├── User.java
├── UserManager.java
├── Task.java
├── TaskManager.java
├── FileHandler.java
├── users.txt
└── <username>_tasks.txt
```

---

## How to Run

1. Open the project in VS Code or any Java IDE
2. Compile all files:

   ```
   javac *.java
   ```
3. Run the application:

   ```
   java Main
   ```

---

## Concepts Applied

* Object-Oriented Programming (encapsulation, class design)
* File handling for persistent storage
* Collections (ArrayList)
* Exception handling
* Event-driven programming using Swing

---

## Future Improvements

* Integration with a database (MySQL or SQLite)
* Enhanced user interface design
* Web-based version of the application
* Notification and reminder system

---

## Learning Outcomes

Through this project, I gained practical experience in:

* Designing and implementing a real-world application
* Applying core Java concepts in a structured manner
* Building graphical interfaces using Swing
* Managing data persistence without external databases

---

## Author

Abhay Mourya
B.Tech Computer Science Engineering
VIT Bhopal

---

## Conclusion

This project demonstrates how core Java concepts can be used to build a functional and user-oriented application. It reflects a structured approach to problem-solving, with emphasis on usability, modular design, and real-world relevance.

---
