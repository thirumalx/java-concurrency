# How to Decide Number of Threads?

* [CPU-bound Tasks](#cpu-bound-tasks) - Use fewer threads (≈ core count).
* [I/O-bound Tasks](#io-bound-tasks) - Use more threads to cover wait time


## CPU-bound Tasks

Tasks that use a lot of CPU power (e.g., calculations, data processing).

* `Threading:` More threads won’t help much, and can actually hurt performance due to context switching.
* `Optimal Threads:` Typically, 1 thread per CPU core is enough.

Use:

```java
Threads ≈ Number of CPU cores (Runtime.getRuntime().availableProcessors())
```
Example: For 8 cores, use 8–10 threads.

## I/O-bound Tasks

Tasks that spend time waiting for external resources (e.g., network, disk operations).

* `Threading:` More threads can improve performance, as threads spend a lot of time waiting and other threads can run during that wait.
* `Optimal Threads:` You can use many more threads than CPU cores (e.g., 50+ threads on a 4-core machine).

Use more threads than cores:

```java
Threads = Cores * (1 + Wait Time / Compute Time)
```
Example: For 4 cores and lots of waiting, 50+ threads might be fine.