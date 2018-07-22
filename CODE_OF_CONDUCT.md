# Code of conduct

All the code, and documentation must be written in English.

When you have finished your stuff in a branch. We work by pull request, and after validation : we merge into master.

## Libraries

When you are coding a library, after putting the card in nut-libraries project as 'In-progress', and had written in the associated issue that you are doing it. You have to create new branch from master. In this branch named like your language (example : C-library). You can only change the subdirectories listed below. This is to prevent massive git conflicts when merging.
 - /core/{LANGUAGE}
 - /test_utils/core/{LANGUAGE}
 - /doc/core/{LANGUAGE}
 - /doc/dev
 - /examples

In common directories, make sure that you change content in every branch (at least your language and master). Create a issue, then others can update their own branch.

Do not touch branch of others... Unless they allow it.

To validate a core library, and to merge to master, you need:
 - the code library
 - an associated little program that:
    - use the library.
    - take a filepath as argument.
    - exits with 0 return code, it it's all good.
    - exits with 1 return code, with the error code, given by the library, written on stderr.
 - respect the ratio N/Files that is given in the section below.
 - the little program has the correct behaviour for all files in examples folder
 - the associated documentation stored in /doc/core
 - a README file must be present in the code folder that explains how you have written the library (depedency, compile, Makefile... etc)

## Other stuff

Little stuff can be made in master branch, directly if it refer to a issue. It means that nothing can't be done in master, if they is no associated issue. If, for some reason, you want to do changes or add a new feature, create an associated issue to explain what you did / will do.

Otherwise, if it's a feature, create a issue and a new branch.
