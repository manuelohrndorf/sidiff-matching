<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore">

<!-- ********************************************************************************** -->
<!-- This XSLT does a preparation of RSM-exported .ecore files into files ready for -->
<!-- code generation -->
<!-- ********************************************************************************** -->
<!-- It transforms documentation tags from RSM-exported .ecore files into -->
<!-- eAnnotations. The documentation tags are seperated by commatas (";"). In order -->
<!-- to be regarded as eAnnotation tag they need to start with "@" -->
<!-- Example: -->
<!-- Documentation tag "This class does something;@IGNOREDIFF" -->
<!-- becomes to an eAnnotation "IGNOREDIFF" -->
<!-- ********************************************************************************** -->
<!-- Furthermore dummy classes are created in empty packages in order to force the -->
<!-- generation of this package. -->
<!-- ********************************************************************************** -->
<!-- Author: Sven Wenzel -->
<!-- ********************************************************************************** -->

<!-- Mark that the output file has been prepared for code generation -->
<xsl:template match="/*">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
 <eAnnotations>
        <xsl:attribute name="source">Genuine-SiDiff-Model</xsl:attribute>
 </eAnnotations>
</xsl:copy>
</xsl:template>


<!-- eAnnotations aus Dokumentationsfeldern generieren -->
<xsl:template match="eAnnotations[@source='http://www.eclipse.org/emf/2002/GenModel']">
<xsl:call-template name="annotation">
      <xsl:with-param name="string" select="./details/@value" />
</xsl:call-template>
</xsl:template>

<xsl:template match="eAnnotations[@source='com.ibm.xtools.common.ui.reduction.editingCapabilities']" />

<xsl:template name="annotation">
  <xsl:param name="string" />
  <xsl:choose>
    <xsl:when test="contains($string, ';')">
      <xsl:if test="starts-with($string, '@')">
        <eAnnotations>
        <xsl:attribute name="source"><xsl:value-of select="substring(substring-before($string,';'), 2)" /></xsl:attribute>
        </eAnnotations>
      </xsl:if>
      <xsl:call-template name="annotation">
        <xsl:with-param name="string" select="substring-after($string, ';')" />
      </xsl:call-template>
    </xsl:when>
    <xsl:otherwise>
      <xsl:if test="starts-with($string, '@')">
        <eAnnotations>
        <xsl:attribute name="source"><xsl:value-of select="substring($string, 2)" /></xsl:attribute>
        </eAnnotations>
      </xsl:if>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>


<!-- Dummyklassen in leeren Paketen anlegen -->
<xsl:template match="ecore:EPackage[not(./eClassifiers)]">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
<eClassifiers xsi:type="ecore:EClass" name="Dummy" abstract="true" />
</xsl:copy>
</xsl:template>

<xsl:template match="eSubpackages[not(./eClassifiers)]">
<xsl:copy>
<xsl:attribute name="nsURI"><xsl:value-of select="../@nsURI" /><xsl:text>/</xsl:text><xsl:value-of select="@name" /></xsl:attribute>
<xsl:apply-templates select="@*[name()!='nsURI'] | node()"/>
<eClassifiers xsi:type="ecore:EClass" name="Dummy" abstract="true" />
</xsl:copy>
</xsl:template>

<!-- nsURIs ersetzen -->
<xsl:template match="eSubpackages">
<xsl:copy>
<xsl:attribute name="nsURI">
<xsl:value-of select="//@nsURI" /><xsl:text>/</xsl:text>
<xsl:for-each select="ancestor::eSubpackages">
<xsl:value-of select="@name" /><xsl:text>/</xsl:text>
</xsl:for-each>
<xsl:value-of select="@name" />
</xsl:attribute>
<xsl:apply-templates select="@*[name()!='nsURI'] | node()"/>
</xsl:copy>
</xsl:template>

<!-- Rest kopieren -->
<xsl:template match="@* | node()">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
</xsl:copy>
</xsl:template>

<!-- Loeschen des Paketes mit importierten klassen (Konvention -> Paket 'import') -->
<xsl:template match="eSubpackages[@name='import']" /> 



</xsl:stylesheet>