package com.valpu.seve.applicationtest.models

import android.os.Parcel
import android.os.Parcelable

// Parcel es un contenedor para un mensaje.
// Puede ser usado para mandar un object serializado a través de Intent
// Mejor rendimiento que Serializer
data class Student(var name: String,
                   var lastName: String,
                   var age: Int,
                   var isDeveloper: Boolean = true) : Parcelable {

    // Leerá los datos del constructor
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    // Escribirá los datos recibidos, se tienen que pasar en el mismo orden que en el constructor
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    // Describe el tipo de contenido del objecto Parcelable
    // 0 Siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR, para tipos de obectos que implementan File Descriptor
    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Student> {

        //Esto Creará el objecto desde el parcel llamando al constructor SECUNDARIO
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        // Esto ayudará a serializar arrays de objectos del mismo tipo que esta clase (Student)
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)
    }
}