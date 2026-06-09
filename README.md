Student Record Management System

This project is built using Java OOP and File I/O.

Features:
- Add, Search, Update, Delete Students
- Display all students
- Store data using:
  * Text files (Scanner, PrintWriter)
  * Binary files (DataInputStream, DataOutputStream)
  * Serialization (ObjectInputStream, ObjectOutputStream)
- Generate GPA report (total, highest, lowest, average)
- Backup system using Buffered Streams
- File class used for directory and file management

How it works:
- Student data is stored in ArrayList during runtime
- Data can be saved and loaded from different file types
- FileManager handles file creation and backup
- ReportGenerator calculates GPA statistics