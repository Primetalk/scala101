# scala101 - Scala Introduction

## Prerequisites

openjdk-8 - https://openjdk.java.net/install/index.html - Java development kit
git - https://git-scm.com/ - version control system
mill - http://www.lihaoyi.com/mill/ - build system for Scala

IntelliJ Idea Community Edition - https://www.jetbrains.com/idea/download/ - IDE

## Getting started

1. Clone project

```bash
git clone git@github.com:/Primetalk/scala101.git
cd scala101
```

2. Build

```bash
mill hello.compile
```

3. Generate IntelliJ Idea project

```bash
mill mill.scalalib.GenIdea/idea
```

4. REPL

```bash
mill -i hello.repl
```

## Hello World

1. Create a file in

hello/src/main/scala/org/primetalk/scala101/hello
    HelloWorld.scala

```bash
mkdir -p hello/src/main/scala/org/primetalk/scala101/hello/
tee hello/src/main/scala/org/primetalk/scala101/hello/HelloWorld.scala <<EOF
package org.primetalk.scala101.hello

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
  }
}
EOF
```

2. Make it (produce .jar)

```bash
mill hello.assembly
```

3. Run

```bash
java -jar out/hello/assembly/dest/out.jar
```
