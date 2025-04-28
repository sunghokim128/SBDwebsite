# SBD Website (samde500)

> A lightweight community bulletin board for weight‐lifting enthusiasts, built during my Summer 2022 internship at Twolinecode.

**⏰ Duration:** July 2022 – August 2022  
**🔗 Live Demo (archived):**  
- [YouTube Short #1](https://www.youtube.com/shorts/ezUNKFt4c9U)  
- [YouTube Short #2](https://www.youtube.com/shorts/xLW9rmqSPJo)  

---

## 🚀 Table of Contents

- [About](#about)  
- [Features](#features)  
- [Technologies](#technologies)  
- [Architecture & Deployment](#architecture--deployment)  
- [Getting Started](#getting-started)  
- [Lessons Learned](#lessons-learned)  
- [License](#license)  

---

## 📝 About

SBD Website (“samde500”) is a simple online bulletin board where lifters can post and validate their Squat, Bench-press, and Deadlift (SBD) numbers with proof videos. By requiring video links for every post, it creates a wholesome, judgment-free space for sharing gym achievements—silencing anonymous “mid” comments and encouraging genuine camaraderie.

---

## ✨ Features

- **Create / Read / Delete posts**  
- **Pagination** for easy browsing  
- **Input validation**  
  - Requires users to enter their SBD numbers  
  - Must include video links as proof  
- **Wholesome community**: no anonymous haters—only lifters validate each other’s progress  

---

## 🛠️ Technologies

| Layer          | Tools & Frameworks                      |
| -------------- | ---------------------------------------- |
| **Backend**    | Java, Spring Boot, MyBatis, MySQL       |
| **Frontend**   | HTML, CSS, JavaScript                   |
| **Deployment** | Amazon EC2 (Free Tier)                  |

---

## 🏗️ Architecture & Deployment

1. **Design & Mockup**  
   - Wireframes created in NinjaMock → converted to HTML/CSS by frontend dev  
2. **Backend**  
   - Spring Boot application with REST controllers  
   - MyBatis + XML mappers for database operations  
3. **Database**  
   - MySQL for storing posts, user records, video links  
4. **Validation Logic**  
   - JavaScript on the client side to prevent invalid submissions  
5. **Hosting**  
   - Deployed on an Amazon EC2 instance (t2.micro)  
   - Domain purchased via Porkbun (samde500)  
   - *Note:* EC2 instance was terminated after first billing cycle, so demo is no longer live  
