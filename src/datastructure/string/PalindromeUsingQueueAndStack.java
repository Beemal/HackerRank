package datastructure.string;

//     Author: Rodney Shaghoulian
//     Github: github.com/rshaghoulian
// HackerRank: hackerrank.com/rshaghoulian

import java.io.*;
import java.util.*;

// ArrayDeque "is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue." - Java documentation

public class PalindromeUsingQueueAndStack {

	/* Stack - using an ArrayDeque */
	ArrayDeque<Character> dequeAsStack = new ArrayDeque<>();

	/* Queue - using an ArrayDeque */
	ArrayDeque<Character> dequeAsQueue = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		// Convert input String to an array of characters:
		char[] s = input.toCharArray();

		// Create a Solution object:
		PalindromeUsingQueueAndStack p = new PalindromeUsingQueueAndStack();

		// Enqueue/Push all chars to their respective data structures:
		for (char c : s) {
			p.pushCharacter(c);
			p.enqueueCharacter(c);
		}

		// Pop/Dequeue the chars at the head of both data structures and compare
		// them:
		boolean isPalindrome = true;
		for (int i = 0; i < s.length / 2; i++) {
			if (p.popCharacter() != p.dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

		// Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is " + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
	}

	void pushCharacter(char ch) {
		dequeAsStack.push(ch);
	}

	char popCharacter() {
		return dequeAsStack.pop();
	}

	void enqueueCharacter(char ch) {
		dequeAsQueue.add(ch);
	}

	char dequeueCharacter() {
		return dequeAsQueue.remove();
	}

}
