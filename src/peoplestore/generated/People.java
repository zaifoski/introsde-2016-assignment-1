//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2016.10.24 alle 12:50:47 AM CEST 
//


package peoplestore.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="healthprofile">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "person"
})
@XmlRootElement(name = "people")
public class People {

    protected List<People.Person> person;

    /**
     * Gets the value of the person property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link People.Person }
     * 
     * 
     */
    public List<People.Person> getPerson() {
        if (person == null) {
            person = new ArrayList<People.Person>();
        }
        return this.person;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="healthprofile">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "firstname",
        "lastname",
        "birthdate",
        "healthprofile"
    })
    public static class Person {

        @XmlElement(required = true)
        protected String firstname;
        @XmlElement(required = true)
        protected String lastname;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar birthdate;
        @XmlElement(required = true)
        protected People.Person.Healthprofile healthprofile;
        @XmlAttribute(name = "id")
        protected String id;

        /**
         * Recupera il valore della proprietà firstname.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstname() {
            return firstname;
        }

        /**
         * Imposta il valore della proprietà firstname.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstname(String value) {
            this.firstname = value;
        }

        /**
         * Recupera il valore della proprietà lastname.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastname() {
            return lastname;
        }

        /**
         * Imposta il valore della proprietà lastname.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastname(String value) {
            this.lastname = value;
        }

        /**
         * Recupera il valore della proprietà birthdate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBirthdate() {
            return birthdate;
        }

        /**
         * Imposta il valore della proprietà birthdate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBirthdate(XMLGregorianCalendar value) {
            this.birthdate = value;
        }

        /**
         * Recupera il valore della proprietà healthprofile.
         * 
         * @return
         *     possible object is
         *     {@link People.Person.Healthprofile }
         *     
         */
        public People.Person.Healthprofile getHealthprofile() {
            return healthprofile;
        }

        /**
         * Imposta il valore della proprietà healthprofile.
         * 
         * @param value
         *     allowed object is
         *     {@link People.Person.Healthprofile }
         *     
         */
        public void setHealthprofile(People.Person.Healthprofile value) {
            this.healthprofile = value;
        }

        /**
         * Recupera il valore della proprietà id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Imposta il valore della proprietà id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lastupdate",
            "weight",
            "height",
            "bmi"
        })
        public static class Healthprofile {

            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar lastupdate;
            @XmlElement(required = true)
            protected String weight;
            @XmlElement(required = true)
            protected String height;
            @XmlElement(required = true)
            protected String bmi;

            /**
             * Recupera il valore della proprietà lastupdate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getLastupdate() {
                return lastupdate;
            }

            /**
             * Imposta il valore della proprietà lastupdate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setLastupdate(XMLGregorianCalendar value) {
                this.lastupdate = value;
            }

            /**
             * Recupera il valore della proprietà weight.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWeight() {
                return weight;
            }

            /**
             * Imposta il valore della proprietà weight.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWeight(String value) {
                this.weight = value;
            }

            /**
             * Recupera il valore della proprietà height.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeight() {
                return height;
            }

            /**
             * Imposta il valore della proprietà height.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeight(String value) {
                this.height = value;
            }

            /**
             * Recupera il valore della proprietà bmi.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBmi() {
                return bmi;
            }

            /**
             * Imposta il valore della proprietà bmi.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBmi(String value) {
                this.bmi = value;
            }

        }

    }

}
