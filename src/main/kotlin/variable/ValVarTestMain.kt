package variable

class ValVarTestMain {
    val mVal = "val"
    private val mPrivateVal = "privateVal"
    public val mPublicVal = "publicVal"
    val mGetVal get() = "getVal"
    private val mPrivateGetVal get() = "privateVal"
    public val mPublicGetVal get() = "publicVal"

    var mVar = "var"
    private var mPrivateVar = "privateVar"
    public var mPublicVar = "publicVar"
    var mGetVar = "getVar"
        set(value) {
            field = value
        }
        get() = "getVar"
    private var mPrivateGetVar = "privateGetVar"
        set(value) {
            field = value
        }
        get() = "privateVar"
    public var mPublicGetVar = "publicGetVar"
        get() = "mPublicVar"
}