package day1

class Day1 {
    companion object {
        fun run(): Int {
            // 1. Read file into 2 lists
            val (list1, list2) = getLocations()

            // 2. Sort the lists
            list1.sort()
            list2.sort()

            // 3. Reduce pair distances
            var i = 0
            var sum = 0

            while (i < list1.size) {
                val distance = if (list1[i] > list2[i]) list1[i] - list2[i] else list2[i] - list1[i]
                sum += distance
                i++
            }
            return sum
        }

        fun similarity(): Int {
            val (list1, list2) = getLocations()

            // 1. Compute occurrences in second list
            val occurrences = mutableMapOf<Int, Int>()
            var i = 0
            while (i < list2.size) {
                val key = list2[i]
                if (!occurrences.containsKey(key)) {
                    occurrences[key] = 1
                } else {
                    occurrences.computeIfPresent(key) { _, cur -> cur+1 }
                }
                i++
            }

            // 2. Compute similarity
            var similarity = 0
            list1.forEach {
                similarity += it * occurrences.getOrDefault(it, 0)
            }
            return similarity
        }

        private fun getLocations(): LocationIds {
            val list1 = mutableListOf<Int>()
            val list2 = mutableListOf<Int>()

            this::class.java.getResourceAsStream("input.txt")
                .bufferedReader()
                .forEachLine {
                    run {
                        val split = it.split("   ")
                        list1.add(split[0].toInt())
                        list2.add(split[1].toInt())
                    }
                }

            return LocationIds(list1, list2)
        }
    }
}