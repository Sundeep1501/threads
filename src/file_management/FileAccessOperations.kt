package file_management

interface FileAccessOperations{
    fun requestReadAccess()
    fun releaseReadAccess()
    fun requestWriteAccess()
    fun releaseWriteAccess()
}