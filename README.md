# Soviet Joke Generator
Soviet Joke Generator is a Java program that randomly generates "In Soviet Russia" jokes and compares the SHA-256 hash codes of two jokes to find the highest match. The jokes are constructed using random combinations of nouns and verbs, producing amusing sentences like "In Soviet Russia, Bitcoin mine you."

## Features
- Generates random "In Soviet Russia" jokes by combining a fixed phrase with random nouns and verbs.
- Uses SHA-256 hashing to compare jokes and find the highest matching characters in their hash codes.
- Writes over 1.7 million jokes to a file for analysis.
- Efficiently reads, writes, and processes large text files using `BufferedReader` and `BufferedWriter`.
- SHA-256 comparison implemented through Java's `MessageDigest` class.

### Prerequisites
- Java Development Kit (JDK) installed.
- Basic understanding of file handling in Java (`BufferedReader`, `BufferedWriter`).
- Familiarity with SHA-256 hashing in Java.

### How to Run
1. Clone the repository.
2. Open the project in your preferred Java IDE.
3. Run the program, which generates jokes, writes them to a file, and compares their SHA-256 hash codes.
4. Observe the output of the two jokes with the highest match score.
