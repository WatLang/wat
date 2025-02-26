package com.kea.KeaVM.Instructions;

import com.kea.KeaVM.Boxes.VmBaseInstructionsBox;
import com.kea.KeaVM.KeaVM;
import com.kea.KeaVM.VmAddress;
import com.kea.KeaVM.VmFrame;
import lombok.Getter;
import lombok.Setter;

/*
IF для VM
 */
@SuppressWarnings("ConstantValue")
@Getter
public class VmInstructionIf implements VmInstruction {
    // адресс
    private final VmAddress addr;
    // инструкции
    @Setter
    private VmBaseInstructionsBox conditions = new VmBaseInstructionsBox();
    private final VmBaseInstructionsBox instructions = new VmBaseInstructionsBox();
    // else
    @Setter
    private VmInstructionIf elseInstruction;

    public VmInstructionIf(VmAddress addr) {
        this.addr = addr;
    }

    public static <T> T cast(Class<T> clazz, Object o) {
        return clazz.cast(o);
    }

    @Override
    public void run(KeaVM vm, VmFrame<String, Object> frame) {
        Object val = conditions.runAndGet(vm, frame);
        if (((Boolean) val)) {
            instructions.run(vm, frame);
        } else {
            if (elseInstruction != null) {
                elseInstruction.run(vm, frame);
            }
        }
    }

    @Override
    public String toString() {
        return "IF_VALUE(conditions: " + conditions + ", body: " + instructions + ")";
    }
}
