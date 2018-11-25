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

## Use ssh with github

1. Generate key

```bash
ssh-keygen
```

This command will create a pair of keys - private and public. Private should be kept
in secret.

2. Show PUBLIC key (~/.ssh/id_rsa.pub)

```bash
cat ~/.ssh/id_rsa.pub
```

3. Add public key to github

In the right hand corner there is your avatar and a drop down menu. Select
"Settings", then "SSH and GPG keys", then press "New SSH key". Paste your key there.

4. Use SSH-method for cloning the scala101 repository

```bash
git clone git@github.com:/Primetalk/scala101.git
```

