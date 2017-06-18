class settings implements Serializable {
  private String colorName
  private String colorCode
  private String mailSubject
  private String mailContent
  private String buildStatus
    
  def setcolorName(value) {
      colorName = value
  }
  def getcolorName() {
      colorNameå
  }
  def setcolorCode(value) {
      colorCode = value
  }
  def getcolorCode() {
      colorCode
  }

  def setmailSubject(value) {
      mailSubject = value
  }
  def getmailSubject() {
      mailSubject
  }

  def setmailContent(value) {
      mailContent = value
  }
  def getmailContent() {
      mailContent
  }
  
  def setbuildStatus(value) {
      buildStatus = value
  }
  def getbuildStatus() {
      buildStatus
  }
}
