package NO_0210_Course_Schedule_II

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preMap = HashMap<Int, MutableList<Int>>()
        prerequisites.forEach {
            preMap.getOrPut(it[0]) { ArrayList() }.add(it[1])
        }
        val visited = BooleanArray(numCourses)
        val res = IntArray(numCourses)
        var ri = 0
        for (i in 0..<numCourses) {
            for (j in 0..<numCourses) {
                if (!visited[j] && preMap[j]?.all { visited[it] } != false) {
                    res[ri++] = j
                    visited[j] = true
                }
                if (ri == numCourses) return res
            }
        }
        return IntArray(0)
    }
}