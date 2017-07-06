package Chapter4.k4

/**
 * Created by MurphySL on 2017/5/27.
 */
data class Student(val name : String){
    object StudentComparator : Comparator<Student>{
        override fun compare(o1: Student, o2: Student): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(args: Array<String>) {
    val stu1 = Student("Herry")
    val stu2 = Student("Jim")
    val list = listOf(stu1, stu2)
    println(list.sortedWith(Student.StudentComparator))
}