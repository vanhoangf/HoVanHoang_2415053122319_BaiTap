data class Student(val studentID: String, val fullName: String, val age: Int, val major: String, val GPA: Float)

fun displayList(list: List<Student>) {
    if (list.isEmpty()) {
        println("Không tìm thấy sinh viên nào")
    } else {
        println("---------------------------------------------------------")
        for (stu in list) {
            println("ID: ${stu.studentID} | Name: ${stu.fullName} | Age: ${stu.age} | Major: ${stu.major} | GPA: ${stu.GPA}")
        }
        println("---------------------------------------------------------")
    }
}

fun main() {
    val students: MutableList<Student> = mutableListOf()
    var chose: Int

    do {
        println("\n========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student")
        println("4. Calculate average GPA")
        println("5. Find specific students")
        println("6. Remove student")
        println("7. Count students")
        println("8. Sort students")
        println("0. Exit")
        println("========================================")
        print("Choose: ")

        chose = readlnOrNull()?.toIntOrNull() ?: -1

        when (chose) {
            1 -> {
                print("Số sinh viên cần nhập: ")
                val sl = readlnOrNull()?.toIntOrNull() ?: 0
                for (i in 1..sl){
                    print("Nhập studentID: ")
                    val id = readlnOrNull() ?: ""
                    print("Nhập fullName: ")
                    val name = readlnOrNull() ?: ""
                    print("Nhập age: ")
                    val age = readlnOrNull()?.toIntOrNull() ?: 0
                    print("Nhập major: ")
                    val major = readlnOrNull() ?: ""
                    print("Nhập GPA: ")
                    val gpa = readlnOrNull()?.toFloatOrNull() ?: 0.0f
                    val student = Student(id, name, age, major, gpa)
                    students.add(student)
                    println("---------------------------------------------------------")
                }
                println("Thêm sinh viên thành công")
            }
            2 -> {
                println("--- DANH SÁCH TẤT CẢ SINH VIÊN ---")
                displayList(students)
            }
            3 -> {
                println("a. Tìm sinh viên theo một phần tên")
                println("b. Tìm tất cả sinh viên thuộc một ngành")
                println("c. Tìm sinh viên có GPA nằm trong khoảng 7.0 -> 8.5")
                print("Chọn (a/b/c): ")
                when (readlnOrNull()?.lowercase()) {
                    "a" -> {
                        print("Nhập từ khóa tên: ")
                        val keyword = readlnOrNull() ?: ""
                        val found = students.filter { it.fullName.contains(keyword, ignoreCase = true) }
                        displayList(found)
                    }
                    "b" -> {
                        print("Nhập tên ngành: ")
                        val major = readlnOrNull() ?: ""
                        val found = students.filter { it.major.equals(major, ignoreCase = true) }
                        displayList(found)
                    }
                    "c" -> {
                        val found = students.filter { it.GPA in 7.0f..8.5f }
                        displayList(found)
                    }
                    else -> println("Lựa chọn không hợp lệ")
                }
            }
            4 -> {
                println("a. Tính GPA trung bình của tất cả sinh viên")
                println("b. Tính GPA trung bình của sinh viên ngành được giao")
                print("Chọn (a/b): ")
                when (readlnOrNull()?.lowercase()) {
                    "a" -> {
                        if (students.isNotEmpty()) {
                            println("Tổng GPA trung bình: ${students.map { it.GPA }.average()}")
                        } else println("Danh sách trống")
                    }
                    "b" -> {
                        print("Nhập tên ngành cần tính: ")
                        val major = readlnOrNull() ?: ""
                        val majorStudents = students.filter { it.major.equals(major, ignoreCase = true) }
                        if (majorStudents.isNotEmpty()) {
                            println("GPA trung bình ngành $major: ${majorStudents.map { it.GPA }.average()}")
                        } else println("Không có sinh viên ngành này!")
                    }
                    else -> println("Lựa chọn không hợp lệ")
                }
            }
            5 -> {
                println("a. Tìm sinh viên có GPA cao nhất")
                println("b. Tìm sinh viên lớn tuổi nhất")
                println("c. Hiển thị 3 sinh viên có GPA cao nhất")
                print("Chọn (a/b/c): ")
                when (readlnOrNull()?.lowercase()) {
                    "a" -> {
                        val maxGpaStudent = students.maxByOrNull { it.GPA }
                        if (maxGpaStudent != null) displayList(listOf(maxGpaStudent)) else println("Danh sách trống")
                    }
                    "b" -> {
                        val oldestStudent = students.maxByOrNull { it.age }
                        if (oldestStudent != null) displayList(listOf(oldestStudent)) else println("Danh sách trống")
                    }
                    "c" -> {
                        val top3 = students.sortedByDescending { it.GPA }.take(3)
                        displayList(top3)
                    }
                    else -> println("Lựa chọn không hợp lệ")
                }
            }
            6 -> {
                print("Nhập StudentID của sinh viên cần xóa: ")
                val id = readlnOrNull() ?: ""
                val isRemoved = students.removeIf { it.studentID == id }
                if (isRemoved) println("Đã xóa thành công!") else println("=> Không tìm thấy sinh viên với ID này")
            }
            7 -> {
                val gpaHigh = students.count { it.GPA >= 8.0f }
                val gpaLow = students.count { it.GPA < 5.0f }
                println("Số lượng sinh viên có GPA >= 8.0: $gpaHigh")
                println("Số lượng sinh viên có GPA < 5.0: $gpaLow")
            }
            8 -> {
                println("a. Sắp xếp sinh viên theo GPA giảm dần")
                println("b. Sắp xếp sinh viên theo tuổi (tăng dần)")
                println("c. Sắp xếp sinh viên theo tên")
                print("Chọn (a/b/c): ")
                when (readlnOrNull()?.lowercase()) {
                    "a" -> displayList(students.sortedByDescending { it.GPA })
                    "b" -> displayList(students.sortedBy { it.age })
                    "c" -> displayList(students.sortedBy { it.fullName })
                    else -> println("Lựa chọn không hợp lệ")
                }
            }
            0 -> break
            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại")
        }
    } while (chose != 0)
}