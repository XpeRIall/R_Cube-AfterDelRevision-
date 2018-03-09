
    public boolean TakeFirst(int x, int y) {
        if (dragStart == null) {
            dragStart = new position(x,y,z);
            dragCtrlKey = (Event.CTRL_MASK) != 0;
            return true;
        } else {
            return true;
        }
    }


    public boolean mouseUp(int x, int y) {
        if (start == null) {
            return true;
        }

        int[] cache = new int[arr.length()];
        cubeP stop = new cubeP(x, y, offsX,
                offsY, dragStart.face);

        int X = compare(stop.X.get() - start.X.get());
        int Y = compare(stop.Y.get() - start.Y.get());
        int Z = compare(stop.Z.get() - start.Z.get());

        boolean rotation = false;

        for (int faceNo = 0; faceNo < displayTable.length(); faceNo++) {
            cache[faceNo] = cube.getCellColor(displayTable.get(faceNo).getxSource(),
                    displayTable.get(faceNo).getySource(), displayTable.get(faceNo).getzSource(),
                    displayTable.get(faceNo).getFaceSource());
        }

        if (dragStart.face == BASE_FACE_X_VISIBLE) {
            if (deltaY == 0 && deltaZ != 0) {
                cube.sliceRotate(CUBE_AXIS_Y, -deltaZ, dragStart.cubeY.get(),
                        dragCtrlKey);
                rotation = true;

            } else if (deltaY != 0 && deltaZ == 0) {
                cube.sliceRotate(CUBE_AXIS_Z, deltaY, dragStart.cubeZ.get(),
                        dragCtrlKey);
                rotation = true;
            }

        } else if (dragStart.face == BASE_FACE_Y_VISIBLE) {
            if (deltaX == 0 && deltaZ != 0) {
                cube.sliceRotate(CUBE_AXIS_X, deltaZ, dragStart.cubeX.get(),
                        dragCtrlKey);
                rotation = true;

            } else if (deltaX != 0 && deltaZ == 0) {
                cube.sliceRotate(CUBE_AXIS_Z, -deltaX, dragStart.cubeZ.get(),
                        dragCtrlKey);
                rotation = true;
            }

        } else if (dragStart.face == BASE_FACE_Z_VISIBLE) {
            if (deltaX == 0 && deltaY != 0) {
                cube.sliceRotate(CUBE_AXIS_X, -deltaY, dragStart.cubeX.get(),
                        dragCtrlKey);
                rotation = true;

            } else if (deltaX != 0 && deltaY == 0) {
                cube.sliceRotate(CUBE_AXIS_Y, deltaX, dragStart.cubeY.get(),
                        dragCtrlKey);
                rotation = true;
            }

        }
        return true;
    }
