package com.freesith.manhole.plugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class OkHttpVisitor extends ClassVisitor implements Opcodes  {

    private String mClassName

    OkHttpVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv)
    }

    @Override
    void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.mClassName = name
        super.visit(version, access, name, signature, superName, interfaces)
    }

    @Override
    MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions)
        if ("okhttp3/OkHttpClient" == this.mClassName) {
            if ("<init>" == name && '''(Lokhttp3/OkHttpClient$Builder;)V''' == desc) {
                return new OkHttpMethodVisitor(mv)
            }
        }
        return mv
    }
}