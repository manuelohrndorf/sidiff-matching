<?xml version="1.0" encoding="ISO-8859-1"?>

<!-- ************************************************************* -->
<!-- XSLT to import an *.xmi file from Fujaba  -->
<!-- into an org.sidiff.uml.model instance -->
<!-- ************************************************************* -->
<!-- Not supported yet: -->
<!--  -->
<!-- ************************************************************* -->
<xsl:transform xmlns:xmi="http://www.omg.org/XMI" 
	       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	       xmlns:UML="http://www.omg.org/uml/1.3" 
	       exclude-result-prefixes="UML"
	       version="1.0">

<xsl:output method="xml" version="1.0" encoding="ISO-8859-1" indent="yes"/>


<!-- ************************************************************* -->
<!-- Keys -->
<!-- ************************************************************* -->
<!-- AssociationEnds -->
<xsl:key name="AssociationEndByIdref" match="UML:AssociationEnd" use="UML:AssociationEnd.participant/UML:Classifier/@xmi.idref"/>
<!-- Attributes -->
<xsl:key name="AttributesByIdref" match="UML:Attribute" use="UML:StructuralFeature.type/UML:Classifier/@xmi.idref"/>
<!-- Operations -->
<xsl:key name="OperationsByIdref" match="UML:Parameter[@kind='return']" use="UML:Parameter.type/UML:Classifier/@xmi.idref"/>
<!-- Parameters -->
<xsl:key name="ParametersByIdref" match="UML:Parameter[@kind!='return']" use="UML:Parameter.type/UML:Classifier/@xmi.idref"/>
<!-- Stereotypes -->
<xsl:key name="StereotypesByIdref" match="UML:Stereotype[@xmi.id]" use="@xmi.id"/>

<!-- ************************************************************* -->
<!-- Error in script, terminate transformation -->
<!-- ************************************************************* -->
<xsl:template match="*">
   <xsl:message terminate='yes'>Error: Could not handle <xsl:value-of select="name()"/></xsl:message>
   <xsl:apply-templates />
</xsl:template>


<!-- ************************************************************* -->
<!-- Entry point -->
<!-- ************************************************************* -->
<xsl:template match="/XMI">
  <xsl:apply-templates select="//UML:Model"/>
</xsl:template>


<!-- ************************************************************* -->
<!-- Model -->
<!-- ************************************************************* -->
<xsl:template match="UML:Model">
<model.core:UMLModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:model.classes="http://www.sidiff.org/org.sidiff.uml.model/classes" xmlns:model.core="http://www.sidiff.org/org.sidiff.uml.model/core" xsi:schemaLocation="http://www.sidiff.org/org.sidiff.uml.model/classes platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//classes http://www.sidiff.org/org.sidiff.uml.model/core platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//core" id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:apply-templates select="//UML:Namespace.ownedElement/UML:Stereotype"/>
  <xsl:apply-templates select="./UML:Namespace.ownedElement/UML:Package"/>
  <!-- TODO Welche ID -->
  <packages id="idPrimitiveTypesPackage" name="UMLPrimitiveTypesPackage">
    <xsl:apply-templates select="//UML:DataType"/>
  </packages> 

</model.core:UMLModel>
</xsl:template>


<!-- ************************************************************* -->
<!-- DataTypes -->
<!-- ************************************************************* -->
<xsl:template match="UML:DataType">
<primitiveTypes id="{@xmi.id}">
  <xsl:variable name="id" select="@xmi.id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="usedByElements">
    <xsl:for-each select="key('AttributesByIdref', @xmi.id)"><xsl:value-of select="@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="key('OperationsByIdref', @xmi.id)"><xsl:value-of select="../../@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="key('ParametersByIdref', @xmi.id)"><xsl:value-of select="../../@xmi.id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
</primitiveTypes>
</xsl:template>


<!-- ************************************************************* -->
<!-- Stereotypes -->
<!-- ************************************************************* -->
<xsl:template match="UML:Stereotype[@xmi.id]">
<stereotypes id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
</stereotypes>
</xsl:template>


<!-- ************************************************************* -->
<!-- Packages -->
<!-- ************************************************************* -->
<xsl:template match="UML:Package">
<packages id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:apply-templates select="./UML:Namespace.ownedElement/UML:Package"/>
  <xsl:apply-templates select="./UML:Namespace.ownedElement/UML:Class"/>
  <xsl:apply-templates select=".//UML:Association"/>
</packages>
</xsl:template>


<!-- ************************************************************* -->
<!-- Classes -->
<!-- ************************************************************* -->
<xsl:template match="UML:Class">
<classifiers xsi:type="model.classes:UMLClass" id="{@xmi.id}">
  <xsl:variable name="id" select="@xmi.id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isAbstract"><xsl:value-of select="@isAbstract"/><xsl:if test="not(@isAbstract)">false</xsl:if></xsl:attribute>
   <!-- usedByElements  --> 
  <xsl:attribute name="usedByElements">
    <xsl:for-each select="key('AttributesByIdref', @xmi.id)"><xsl:value-of select="@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="key('OperationsByIdref', @xmi.id)"><xsl:value-of select="../../@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="key('ParametersByIdref', @xmi.id)"><xsl:value-of select="../../@xmi.id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <!-- Associations  -->
  <xsl:attribute name="targetedByAssociationEnds">
    <xsl:for-each select="key('AssociationEndByIdref', @xmi.id)"><xsl:value-of select="@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <!-- Specializations  -->
  <xsl:attribute name="specializations"><xsl:for-each select="//UML:Generalization[@parent=$id]"><xsl:value-of select="@xmi.id"/><xsl:text> </xsl:text></xsl:for-each></xsl:attribute>
  <!-- Stereotypes  -->
  <xsl:attribute name="stereotypes">
  <xsl:for-each select="key('StereotypesByIdref', ./UML:ModelElement.stereotype/UML:Stereotype/@xmi.idref)"><xsl:value-of select="@xmi.id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <!-- Attributes  -->
  <xsl:apply-templates select="./UML:Classifier.feature/UML:Attribute"/>
  <!-- Operations  -->
  <xsl:apply-templates select="./UML:Classifier.feature/UML:Operation"/>
  <!-- Generalizations  -->
  <xsl:apply-templates select="./UML:Namespace.ownedElement/UML:Generalization"/>
</classifiers>
</xsl:template>


<!-- ************************************************************* -->
<!-- Attributes -->
<!-- ************************************************************* -->
<xsl:template match="UML:Attribute">
<attributes id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isStatic"><xsl:if test="@ownerScope='instance'">false</xsl:if><xsl:if test="@ownerScope='classifier'">true</xsl:if></xsl:attribute>
  <xsl:attribute name="type"><xsl:value-of select="./UML:StructuralFeature.type/UML:Classifier/@xmi.idref"/></xsl:attribute>
  <xsl:attribute name="isReadOnly"><xsl:call-template name="isReadOnly"/></xsl:attribute>
</attributes>
</xsl:template>


<!-- ************************************************************* -->
<!-- Operations -->
<!-- ************************************************************* -->
<xsl:template match="UML:Operation">
<operations id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isStatic"><xsl:if test="@ownerScope='instance'">false</xsl:if><xsl:if test="@ownerScope='classifier'">true</xsl:if></xsl:attribute>
  <xsl:attribute name="isAbstract"><xsl:value-of select="@isAbstract"/><xsl:if test="not(@isAbstract)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="type"><xsl:value-of select="./UML:BehavioralFeature.parameter/UML:Parameter[@kind='return']/UML:Parameter.type/UML:Classifier/@xmi.idref"/></xsl:attribute>
  <xsl:apply-templates select="./UML:BehavioralFeature.parameter/UML:Parameter[@kind!='return']"/>
</operations>
</xsl:template>


<!-- ************************************************************* -->
<!-- Parameters -->
<!-- ************************************************************* -->
<xsl:template match="UML:Parameter">
<parameters id="{../../@xmi.id}_{@name}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="type"><xsl:value-of select="./UML:Parameter.type/UML:Classifier/@xmi.idref"/></xsl:attribute>
  <xsl:attribute name="kind"><xsl:call-template name="kind"/></xsl:attribute>
</parameters>
</xsl:template>


<!-- ************************************************************* -->
<!-- Generalizations -->
<!-- ************************************************************* -->
<xsl:template match="UML:Generalization">
<generalizations id="{@xmi.id}">
  <xsl:attribute name="generalElement"><xsl:value-of select="@parent"/></xsl:attribute>
  <xsl:attribute name="specialElement"><xsl:value-of select="@child"/></xsl:attribute>
</generalizations>
</xsl:template>


<!-- ************************************************************* -->
<!-- Associations -->
<!-- ************************************************************* -->
<xsl:template match="UML:Association">
<associations id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <!-- <xsl:apply-templates select=".//UML:Attribute"/> bei Fujaba nicht gegeben -->
  <xsl:apply-templates select=".//UML:Association.connection/UML:AssociationEnd"/>
</associations>
</xsl:template>


<!-- ************************************************************* -->
<!-- Association Ends -->
<!-- ************************************************************* -->
<xsl:template match="UML:AssociationEnd">
<associationEnds id="{@xmi.id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="multiplicity"><xsl:value-of select="./UML:AssociationEnd.multiplicity/UML:Multiplicity/UML:Multiplicity.range/UML:MultiplicityRange/@lower"/>..<xsl:value-of select="./UML:AssociationEnd.multiplicity/UML:Multiplicity/UML:Multiplicity.range/UML:MultiplicityRange/@upper"/></xsl:attribute>
  <xsl:attribute name="isNavigable"><xsl:value-of select="@isNavigable"/></xsl:attribute>
  <xsl:attribute name="isOrdered"><xsl:if test="@ordering='unordered'">false</xsl:if><xsl:if test="@ordering='ordered'">true</xsl:if></xsl:attribute>
  <xsl:attribute name="kind"><xsl:call-template name="aggregation"/></xsl:attribute>
  <xsl:attribute name="target"><xsl:value-of select="./UML:AssociationEnd.participant/UML:Classifier/@xmi.idref"/></xsl:attribute>
</associationEnds>
</xsl:template>


<!-- ************************************************************* -->
<!-- Translation of visibility values -->
<!-- ************************************************************* -->
<xsl:template name="visibility">
<xsl:choose>
<xsl:when test="@visibility='public'">public</xsl:when>
<xsl:when test="@visibility='protected'">protected</xsl:when>
<xsl:when test="@visibility='private'">private</xsl:when>
<xsl:otherwise>package</xsl:otherwise>
</xsl:choose>
</xsl:template>


<!-- ************************************************************* -->
<!-- Translation of aggregation kind values -->
<!-- ************************************************************* -->
<xsl:template name="aggregation">
<xsl:choose>
<xsl:when test="@aggregation='composite'">composite</xsl:when>
<xsl:when test="@aggregation='aggregate'">shared</xsl:when>
<xsl:otherwise>none</xsl:otherwise>
</xsl:choose>
</xsl:template>


<!-- ************************************************************* -->
<!-- Translation of parameter kind values -->
<!-- ************************************************************* -->
<xsl:template name="kind">
<xsl:if test="@kind='in'">in</xsl:if>
<xsl:if test="@kind='inout'">inout</xsl:if>
</xsl:template>


<!-- ************************************************************* -->
<!-- Translation of Attributes kind values -->
<!-- ************************************************************* -->
<xsl:template name="isReadOnly">
<xsl:choose>
<xsl:when test="@changeability='frozen'">true</xsl:when>
<xsl:otherwise>false</xsl:otherwise>
</xsl:choose>
</xsl:template>


<!-- ************************************************************* -->
<!-- Dependencies -->
<!-- ************************************************************* -->
<xsl:template match="UML:Dependency">
<xsl:message terminate='yes'>Error: Could not handle UML:Dependencies</xsl:message>
</xsl:template>


</xsl:transform>