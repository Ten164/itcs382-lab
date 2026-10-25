Files read: bikeshare-poor/src/main/java/bikeshare/Main.java

| No. | Check | Code location (file:line) | Finding | Severity | Suggested fix |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | Code quality | Main.java:10 | Public static field used for shared data | Should fix | Make fields private and encapsulate them |
| 2 | Code quality | Main.java:19 | Use of System.out instead of a logger | Note | Replace with a proper logger implementation |
| 3 | Coupling | Main.java:25 | Tight coupling in monolithic class handling everything | Should fix | Separate responsibilities into distinct classes |
| 4 | Cohesion | Main.java:38 | Procedural cohesion in method processing multiple actions | Should fix | Split into dedicated methods per action |
| 5 | Code quality | Main.java:55 | Exception is printed using e.printStackTrace() | Should fix | Handle exception properly with a logger |

Check 1 (Code quality): 3
Check 2 (Cohesion, coupling and connascence): 2