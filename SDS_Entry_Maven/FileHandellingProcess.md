# Membership Data Conversion Project

This project is aimed at converting membership data from a fixed-column format to comma-separated-value (CSV) files, following specific client requirements. It includes functionalities to import data from an input file, process it, and export it to multiple CSV files split by state.

## Project Structure

The project consists of the following components:

1. `src/main/java/com/smartdatasolutions/test`: Contains the Java source code.
2. `Members.txt`: Input file containing membership data in a fixed-column format.
3. `output`: Directory to store the output CSV files.

## Prerequisites

Before running the project, ensure you have the following installed:

- Java Development Kit (JDK) version 8 or higher.
- An IDE such as IntelliJ IDEA or Eclipse.

## How to Use

1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Ensure that the input file `Members.txt` is placed in the project root directory.
4. Run the `Main` class located at `src/main/java/com/smartdatasolutions/test/impl/Main.java`.
5. Once the program completes execution, check the `output` directory for the generated CSV files.

## Explanation of Project Flow

1. **Importing Members**: The `MemberImporterImpl` class reads data from the input file (`Members.txt`) and creates `Member` objects. It ensures that each line of the file is properly parsed to extract member information.

2. **Duplicate Removal**: The `Main` class ensures that duplicate member records are removed before further processing. This is achieved by the `getNonDuplicateMembers` method.

3. **Splitting by State**: After removing duplicates, the `Main` class splits the members by state using the `splitMembersByState` method. It creates separate lists of members for each state.

4. **Exporting to CSV**: Finally, the `Main` class utilizes the `MemberExporterImpl` class to export the member data to CSV files. Each CSV file is named with a state prefix and contains member details in the required format.

## Additional Notes

- The project follows the SOLID principles and is modularized for ease of maintenance and testing.
- Make sure to handle any exceptions that may occur during the execution of the program.
- Feel free to extend or modify the project as per your requirements.

For any questions or issues, please contact [project owner/contact person].
