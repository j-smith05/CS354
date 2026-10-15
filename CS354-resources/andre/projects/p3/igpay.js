import readline from 'node:readline';

// Checks whether a character is a vowel.
function isVowel(char) {
  return 'aeiouy'.includes(char.toLowerCase());
}

// Converts a single word into Pig Latin.
function translateWord(word) {
  if (word.length === 0) {
    return word;
  }

  const wasCapitalized = word[0] === word[0].toUpperCase();
  const wasUppercase = word === word.toUpperCase();
  const lowerWord = word.toLowerCase();

  let translated = '';

  if (isVowel(lowerWord[0])) {
    translated = `${lowerWord}yay`;
  } else {
    let index = 0;

    // Find where the first vowel begins.
    while (index < lowerWord.length && !isVowel(lowerWord[index])) {
      index += 1;
    }

    const beginning = lowerWord.slice(0, index);
    const ending = lowerWord.slice(index);

    translated = `${ending}${beginning}ay`;
  }

  // Restore the original capitalization.
  if (wasUppercase) {
    return translated.toUpperCase();
  }

  if (wasCapitalized) {
    return translated[0].toUpperCase() + translated.slice(1);
  }

  return translated;
}

// Translates words while keeping punctuation and spaces.
function translateLine(line) {
  return line.replace(/[a-zA-Z]+(?:['’][a-zA-Z]+)*/g, (word) => translateWord(word));
}

// Read input one line at a time.
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false,
});

rl.on('line', (line) => {
  console.log(translateLine(line));
});
