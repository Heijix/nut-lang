Introduction
============

Nut in a nutshell
-----------------

The idea is to take the advantage of Yaml and Json format and put it in a new great format called Nut.

This new language is a data storing / sharing languages in the same purpose as Yaml or Json. But Yaml is used often especially in configuration. But it is hard to learn and switch between configuration conventions. The two main examples are ansible files and .travis.yml.

This new language answer to this question with a json model, with some addition.

Some additions are about factorisation, others about maintenance...

This language is a answer to a given problem :

We lose too much time to learn a new yaml pattern, and edit those files to use a program or a service that use configuration files ?

This language stores data, and is friendly with Json, but it answers this question with data types, that we can import from the Internet.

Nut as a language
-----------------

Some softwares examples when Nut can be usefull:
 - Docker-compose
 - Kubernetes manifests
 - Ansible
 - Travis file

I divide all the documentation into a few files :
 - [Example Link](./Examples.html) Just a few examples, that can show the power of this language.
 - [Grammar Link](./Grammar.html) The Grammar itself.
 - [Language Explanation Link](./Language.html) A deep explanation of each feature of the language.
 - [Implementation Link](./Implementation.html) A way to implement the language, with a description of each step.
 - [RoadMap](./Roadmap.html) The roadmap, to the creation of the projects.

Nut as a auto-improving language
--------------------------------

Idea features:
 - Data Types can define itself with itseld. Recursive definition. (Maybe a future feature)
 - We try to define a Data Type that is defined later, throw a custom error.
 - Data Types Can Inherit Each others, Abstract Data Types.
