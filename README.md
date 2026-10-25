# CS-320: Software Test, Automation QA

In completing this course, I've applied software engineering testing strategies and practices as part of the software development life cycle, including requirements analysis, verification and validation, and quality management. I've also practiced the creation of unit tests and analysis of various testing approaches.


---

## Repository Contents
* `README.md` - Project scenario and reflections
* `CS 320 Project Two.pdf` - Summary and Reflections Report
* `ContactService/` - Contact service and test files

---

## Project Scenario

You are a software engineer for Grand Strand Systems, a software engineering company that focuses on developing and testing back-end services. You’ve been given an assignment to develop a mobile application for a customer. The customer will provide you with the requirements. Your job is to code up the application and provide unit tests to verify that it meets the customer’s requirements. You will be delivering the contact, task, and appointment services. The purpose of these services is to add, update, and delete contact, task, and appointment objects within the application.

> [!NOTE] 
> This portfolio omits the task and appointment services, including only the contact service.
---

## Week 8 Journal: Reflection

> **How can I ensure that my code, program, or software is functional and secure?**

I ensure functionality and security by implementing defensive programming at the domain level and verifying every execution path with comprehensive automated testing. In this portfolio, I enforced strict input validation and field immutability directly in constructors and mutators using fail-fast helper methods, which prevent invalid or partially initialized states in memory. Pairing boundary value analysis with negative JUnit tests and code coverage metrics guarantees that both expected use cases and edge-case failure modes are handled securely and predictably.   

> **How do I interpret user needs and incorporate them into a program?**

I interpret user needs by deconstructing functional requirements into explicit, measurable constraints and using them as an objective acceptance checklist. Rather than assuming how an end-user will interact with an application, I translate every stated specification, such as non-null bounds, field lengths, and unique IDs, directly into concrete domain logic. I then map each requirement to dedicated positive and negative unit tests to verify that the implementation adheres strictly to the client's specifications without introducing confirmation bias.   

> **How do I approach designing software?**

My approach to software design prioritizes modularity, robust encapsulation, and efficient data structures that prevent shared mutable state. For instance, I choose optimal collections like in-memory hash maps to achieve $O(1)$ lookup and modification times while enforcing data integrity through unique keys. I also design entities to protect their internal representations by making core identifiers final, exposing only necessary mutators, and validating inputs before modifying any internal state.