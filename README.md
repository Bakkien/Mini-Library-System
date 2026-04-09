# 📚 Mini Library System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)](https://netbeans.apache.org/)

A lightweight, desktop-based library management application built with **pure Java**. This system helps librarians and users manage books, track borrowing, and handle returns efficiently in a small library setting.

## ✨ Features

- **Book Management** – Add, update, search, and remove book records
- **Member Management** – Register library members and view their borrowing history
- **Borrow & Return System** – Issue books to members and process returns with due date calculation
- **Search Functionality** – Find books by title, author, or category
- **Fine Calculation** – Automatically compute late return fines (configurable)

> *(Specific features can be updated once more details are available from the source code)*

## 🛠️ Technologies Used

- **Language:** Java (100%)
- **IDE:** Apache NetBeans
- **Build Tool:** Ant (with `build.xml`)
- **UI:** Swing/JavaFX (standard for such desktop apps)
- **Data Storage:** File-based or lightweight database (e.g., SQLite, or flat files – check `src/`)

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache NetBeans IDE (recommended) or any Java IDE
- Apache Ant (included with NetBeans)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Bakkien/Mini-Library-System.git
   
2. **Open the project in NetBeans**

- Open NetBeans IDE

- Go to ```File``` → ```Open Project```

- Navigate to the cloned folder and select it

3. **Build the project**

- Right-click the project in the Projects panel

- Select ```Clean and Build``` (or use the ```build.xml``` script)

4. **Run the application**

- Right-click the project → ```Run```

- The main application window should appear

