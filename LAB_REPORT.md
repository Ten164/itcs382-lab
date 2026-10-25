# Lab Report, Code Quality and Design Quality

Repository URL:

## Tools

| Item | Version or name |
| --- | --- |
| JDK | |
| Maven | |
| IDE | |
| SonarQube for IDE | |
| AI tool and exact model | |

## Task 1. SonarQube on the starter code

Commit of the starter, before any change: 64ea768

Table 1. SonarQube issues in the starter code

| No. | Rule | File:line | Message |
| --- | --- | --- | --- |
| 1 | java:S106 | Main.java:9 |Replace this use of System.out by a logger. |
| 2 | java:S1068 | ParcelService.java:12 | Remove this unused "maxParcels" priv... |
| 3 | java:S2143 | ParcelService.java:1 | Use the "java.time" API for date and time. |

## Task 2. AI review of the starter code

| Item | Value |
| --- | --- |
| Date | 2026-10-25 |
| AI tool and exact model | Gemini |
| Commit reviewed | Starter code |
| How the AI read the files (attached the files, opened the folder, or pasted the files) | pasted the files |
| Output file in the reviews folder | reviews/gemini_review.txt |

Table 2. All findings on the starter code

| No. | File:line | Finding | Found by (SonarQube, AI or both) | SonarQube rule or course term | Correct? (yes or no, and why) |
| --- | --- | --- | --- | --- | --- |
| 1 | Main.java:9 | Replace this use of System.out by a logger | SonarQube | java:S106 | yes, loggers provide better control than System.out |
| 2 | ParcelService.java:12 | Remove this unused "maxParcels" private field | SonarQube | java:S1068 | yes, keeping dead code makes maintenance harder |
| 3 | ParcelService.java:1 | Use the "java.time" API for date and time | SonarQube | java:S2143 | yes, java.util.Date is outdated and bug-prone |
| 4 | ParcelService.java:42 | String comparison using == instead of .equals() | AI | String Equality / Bug | yes, == checks memory reference, not actual string value |
| 5 | ParcelService.java:72 | FileWriter resource is never closed | AI | Resource Leak | yes, unclosed files can cause memory leaks and file locks |
| 6 | ParcelService.java:77 | Empty catch block swallows IOException | AI | Empty Catch Block | yes, silently ignoring errors hides potential crashes |

2.1 Name two problems that only the AI review found.

The string comparison bug using '==' instead of '.equals()' and the unclosed FileWriter resource leak.

2.2 Name one problem that only SonarQube found, or write none.

The unused private field "maxParcels" (Rule java:S1068).

2.3 Name one AI finding that was wrong or too vague, and explain why. If every finding was right, explain how you checked them.

Every finding was right. I checked them by verifying standard Java best practices (e.g., strings must be compared with .equals(), and resources like FileWriter must be closed to prevent memory leaks).

## Task 3. Fix and check

Table 3. What you did with each SonarQube issue in Table 1

| No. in Table 1 | Fixed or kept | Commit, or the reason for keeping it |
| --- | --- | --- |
| 1 | | |

Number of SonarQube issues that remain after your fixes:

The two design problems that you fixed

| Design problem (course term) | What you changed | Commit |
| --- | --- | --- |
| | | |
| | | |

Output of the program after your fixes, for the commands `store P1 6501 2`, `pickup P1 5` and `staff`, and the content of parcels.csv:

```text

```

## Task 4. AI-generated poor and good designs

| Item | bikeshare-poor | bikeshare-good |
| --- | --- | --- |
| Date | | |
| AI tool and exact model | | |
| Prompt (B or C as given, or your changed prompt in full) | | |
| Builds with mvn package (yes or no) | | |
| Number of classes, interfaces, enums and records | | |
| SonarQube issues, total | | |
| SonarQube issues, by rule | | |
| AI review findings in Check 1 | | |
| AI review findings in Check 2 | | |
| Review output file in the reviews folder | | |

4.1 Did SonarQube report any cohesion or coupling problem in bikeshare-poor? Quote the rule and the message if it did.

4.2 Did the AI review tell the two versions apart? Give one finding for bikeshare-poor that does not appear for bikeshare-good.

4.3 Which version would you rather extend with a new member type, such as a visitor who pays 4 baht per minute, and why?

## Task 5. Reflection

5.1 What does SonarQube check, and what does it not check? Answer with examples from this lab.

5.2 When should you not trust the AI review? Give an example from this lab.

5.3 What will you do differently in Project Phase 2 after this lab?

## AI usage declaration

| AI tool and exact model | Purpose | Files or parts that it produced or changed | How you checked its output |
| --- | --- | --- | --- |
| | | | |
