Name:

TDD TODO/Task list

1. First test, program receives input saves to string
2. Test parse each line
2. Test, program recognizes each single digit number (0-9)
   3. Throw OCRexception if input strings arn't same length
   4. Throw OCRexception if input is null
   5. Throw OCRexception if does not translate
   6.
7. Empty String Returns empty String

Start of a new approach to the project (This worked)
This program only needs to create on object which is an OCRTranslator
1. Test find a top pattern in the top string
2. Find a middle pattern in the middle string
3. Find a bottom pattern in the bottom string
4. Save the start index for each pattern
5. Test to see if the start index is the same in each list
6. If so, the number exists at that index
7. add that number and index to a hashmap
8. Sort the hashmap by index, add sorted values to a list
9. Print list
10. Make sure the list returns as a string