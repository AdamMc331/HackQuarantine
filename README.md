# Hack Quarantine Room Demo

This is a sample app demonstrating how to get started with the Room database on Android. We build
an app that shows how to add items to a list, and persist them in a database, so that they can be
requested again when we reopen the app:

![](HackQuarantineDemo.gif)

## Room Basics

In the first part of the workshop, we demonstrate how to add the Room library, add the necessary
annotations, and insert/fetch data from the database. You can find the code from that section [here](https://github.com/AdamMc331/HackQuarantine/pull/1/files).

## Threading

In the second part of the workshop, we demonstrate how to run room queries on a background thread,
so we don't block the UI while talking to the database. You can find that code [here](https://github.com/AdamMc331/HackQuarantine/pull/2/files).

## Additional Resources

* Room: https://developer.android.com/training/data-storage/room
* LiveData: https://developer.android.com/topic/libraries/architecture/livedata