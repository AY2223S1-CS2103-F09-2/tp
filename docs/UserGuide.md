## Optional Parameter 2: Date of Birth

### Format: ```add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [d/DOB]```

- Adds date of birth to a person in the contact list. Date formats accepted are: d.M.yyyy , dd MMM yyyy, M d, yyyy
- NAME can contain more than 1 word.

### Examples:
- ```add n/John Wang p/98765432 e/johnwang@example.com a/John street, block 123, #01-01 d/20.03.2000```
- ```add n/John p/92781123 e/john@example.com a/Donald street, block 248, #02-04 d/20 MAR 2000```
- ```add n/Charlotte p/81286623 e/charlotte@example.com a/Charity street, block 101, #10-82 d/March 20, 2000```

## Optional Parameter 2: Date of Birth

### Format: ```edit INDEX [n/NAME] [d/DOB]```

- Edits the date of birth of a person in the contact list. Date formats accepted are: d.M.yyyy, dd MMM yyyy, M d, yyyy
- INDEX must be positive integers (i.e 1,2,3…)
- INDEX must be within the range of the contact list index (i.e from 1 to size of contact list).

### Examples:
- ```edit 1 d/20.03.2000```
- ```edit 2 d/20 MAR 2000```
- ```edit 3 d/March 20, 2000```
