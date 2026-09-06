import kotlin.math.max

fun main(args: Array<String>)
{
    println("Ho va ten: Ho Van Hoang\nMSV: 2415053122319")
    print("Nhap diem math: ")
    var m: Float = readLine()!!.toFloat()
    print("Nhap diem programming: ")
    var p: Float = readLine()!!.toFloat()
    print("Nhap diem database: ")
    var d: Float = readLine()!!.toFloat()
    var s: Float = m + p + d
    var dtb:Float = s/3
    var max:Float = max(m, max(p,d))
    println("Tong diem 3 mon la: $s")
    println("Diem trung binh 3 mon la: $dtb")
    println("Diem cao nhat trong 3 mon la: $max")
    if (dtb >= 5)
        print("Sinh vien dat")
    else
        print("Sinh vien khong dat")
}