# Cube Solver

**Cube Solver** is a Java application that computes all distinct solid cubes over a given set of colors, accounting for rotational symmetry. The solver uses permutation theory and group theory concepts to determine which cube colorings are equivalent under physical rotation.

> _This project was created as part of **COSC 3327 Algorithms and Data Structures (Fall 2025)** at **St. Edward's University**. This was Part 3 of a 3-part multi-assignment series._


## Overview

Given a set of colors, the **Cube Solver** generates all possible ways to paint a cube's six faces, then identifies which cubes are rotationally equivalent. Two cubes are considered equal if one can be physically rotated to look identical to the other.

The solver leverages mathematical concepts like permutations, cycle notation, and the 24 rotational symmetries of a cube to efficiently determine distinct colorings.


## Features

- **Permutation-Based Rotation System**
  - Models all 24 rotations of a cube using cycle notation
  - Includes vertex-to-vertex, edge-to-edge, and face-to-face rotations
  - Identity permutation handling for fixed orientations

- **Efficient Equality Checking**
  - Custom `hashCode()` and `equals()` implementations for optimal performance
  - Canonical representative selection using lexicographic ordering
  - Hash set deduplication to eliminate rotational duplicates

- **Unicode Visualization**
  - Color-coded square rendering for cube nets
  - Visual representation of cube orientations in console output
  - Supports 7 colors: Red, Green, Blue, Yellow, Orange, Black, White

- **Comprehensive Test Suite**
  - JUnit 4 test cases for 1-7 color inputs
  - Performance benchmarks with timeout constraints
  - Validates expected distinct cube counts


## Screenshots

<p align="center">
  <img src="screenshots/tests_passed.png" width="600">
</p>


## How to Run

1. Clone this repository
2. Open the project in **Eclipse IDE**
3. Ensure **Java 21+** is configured
4. Navigate to `src/test/CubeSolverTests.java`
5. Right-click → **Run As** → **JUnit Test**

### Requirements

- **Java 21** or newer
- **Eclipse IDE** (or any Java IDE with JUnit 4 support)
- **JUnit 4** testing framework


## Tech Stack

- **Language:** Java
- **Testing Framework:** JUnit 4
- **IDE:** Eclipse IDE
- **Paradigm:** Object-Oriented Programming
- **Mathematical Concepts:** Group Theory, Permutations, Rotational Symmetry


## What I Learned

- **Permutations and Rotational Symmetry:** Modeling physical cube rotations using mathematical permutations and cycle notation to represent all 24 symmetries of a cube.

- **Optimizing hashCode/equals for Performance:** Implementing efficient equality checking by selecting canonical representatives and ensuring the `hashCode()`/`equals()` contract is satisfied for hash-based collections.

- **Mathematical Group Theory Concepts:** Applying abstract algebra principles to solve a concrete computational problem, including understanding how rotations form a group under composition.

- **Object-Oriented Design and Separation of Concerns:** Structuring the codebase with clear interfaces (`Cube`, `CubeNet`, `Permutation`) and implementation classes (`CubeImpl_Serna`, `PermutationImpl_Serna`), distinguishing between client-side and implementation-side responsibilities.

- **General Software Development Cycle:** Iterative development starting with core data structures, implementing and testing `equals()`/`hashCode()`, then building up to the full solver with comprehensive test coverage.


## Notes

This project was built for academic purposes as Part 3 of a multi-part assignment series. The focus was on algorithmic problem-solving, mathematical modeling, and efficient implementation rather than production deployment. The repository showcases skills in Java development, algorithm design, testing, and applying theoretical computer science concepts to practical problems.
