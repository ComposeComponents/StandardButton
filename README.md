# Units
[![Build](https://github.com/ComposeComponents/StandardButton/actions/workflows/build.yml/badge.svg)](https://github.com/ComposeComponents/StandardButton/actions/workflows/build.yml)
[![Lint](https://github.com/ComposeComponents/StandardButton/actions/workflows/lint.yml/badge.svg)](https://github.com/ComposeComponents/StandardButton/actions/workflows/lint.yml)

A widget library for generically defining primary/secondary/tertiary button styles.

## Installation
![Stable](https://img.shields.io/github/v/release/ComposeComponents/StandardButton?label=Stable)
![Preview](https://img.shields.io/github/v/release/ComposeComponents/StandardButton?label=Preview&include_prereleases)

```
implementation "cl.emilym.compose:standardbutton:<latest>"
```

## Usage
```kotlin
StandardButton(
    type = ButtonType.PRIMARY,
    onClick = {}
) {
    Text("This is a test of the button")
}
```