# A [Giter8][g8]/[SBT][sbt]/[Scala][scala] template

Forked from DevInsideYou Vlad's original seed.

A Giter8 template for a fully configured Scala3 SBT single but multibuild ready project. It is configured in a slightly opinionated but mostly dependency free fashion.

All versions will always stay hardcoded as opposed to being chooseable or automatically updatable via Giter8 in order to guarantee the soundness of the build. In other words, assuming you don't have any global settings/plugins the build won't break unless you manually break it by changing versions by hand. Enjoy!

Configure your Scala dev environment [in minutes](https://github.com/devinsideyou/scala-seed)!

```bash
sbt new wahtique/scala3-rest-seed.g8
```

or

```
```bash
scala-cli wahtique/scala3-rest-seed.g8
```

[g8]: http://www.foundweekends.org/giter8/
[sbt]: https://www.scala-sbt.org/
[scala]: https://www.scala-lang.org/
