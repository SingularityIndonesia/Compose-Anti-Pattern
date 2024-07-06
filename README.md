Jetpack Compose is remarkably simple, and that's a good thing. However, its simplicity often leads to solutions that are no simpler than the problems they solve.

In object-oriented programming, we can encapsulate a solution into an object and give it a name. We can also create a simple abstraction of the object to hide the internal implementation details.

However, with Jetpack Compose, we may not be able to do this as easily. This is because functions are inherently simple. Abstracting functions often doesn't provide significant benefits, especially when using a pure functional approach where a function has only one input and one output. What solution could be simpler than that?

Solutions in functional programming often take the form of patterns rather than named objects. Therefore, pattern recognition is crucial. It's both simple and incredibly challenging.

I've created this repository to gather patterns that may have detrimental side effects. While (here) they called "Anti Patterns," the purpose is not to categorize them but rather to collect them to form knowledge and enhance pattern recognition skills, both for identifying harmful and beneficial patterns.

# Topic
## 1. A Lambda that Captures State will trigger Recomposition.
Sometimes recomposition happens to the whole page and nobody have any idea why. It probably because of a lambda that capture states.
see: [LamdaCaptureState.kt](composeApp/src/desktopMain/kotlin/topic/LamdaCaptureState.kt)

## 4. I can't go back
Can't go back after navigate because state of the previous page is success(?) Clearing the state is not a good idea though it may works.
[upcomming]

# Contributing
We truly appreciate your interest in contributing! Sharing your knowledge of patterns will be invaluable for everybody. Please contribute!
