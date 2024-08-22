import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom';

//import { toast } from 'react-toastify'
import '../../node_modules/bootstrap/dist/css/bootstrap.css';
var prescription_id;

function DoctorPrescription(){
    const centerDivStyle = {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
      };
    var nav=useNavigate();
    var { id } = useParams();
    var [medicine, setMedicine] = useState([]);

    useEffect(() => {
      
        const url = 'http://localhost:8080/prescription/add';        
        const config = {
          headers: {
            'Content-Type': 'application/json', 
          },
          params: {
            apptid: id 
          }
        };
        
        axios.post(url, formData, config)
          .then(response => {
            
            console.log(response.data);
            console.log("id hai hai : "+response.data.id)
             prescription_id=response.data.id;
            //  d_id=response.data.d_id;
            //  p_id=response.data.p_id;

          })
          .catch(error => {
            // Handle errors
            console.error('An error occurred:', error);
          });

          axios.get("http://localhost:8080/prescription/getmedicines", {

        }).then((response) => {
          /////// 
          ///////
          setMedicine([...response.data]);
          //////
          ////////
        })
    }, [])

    const [formData, setFormData] = useState({

        CreatePrescriptionDetailsDTO: []
    });




    const addMedicine = () => {
        setFormData((prevData) => ({
            ...prevData,
            CreatePrescriptionDetailsDTO: [
                ...prevData.CreatePrescriptionDetailsDTO,
                {
                    m_id: 0,
                    quantity:0,
                    dosage: '',
                    duration: ''
                    
                }
            ]
        }));
    };


    

    const Submit = async () => {

        for (const prescriptionDetail of formData.CreatePrescriptionDetailsDTO) {
          try {
            console.log(prescriptionDetail)

            const response = await axios.post(`http://localhost:8080/prescription/detailsadding/${prescription_id}`, prescriptionDetail);
      

            console.log('Response:', response.data);
          } catch (error) {

            console.error('Error:', error);
          }
        }

        nav("/doctor/appointment");
      };

    const handleMedicineChange = (index, field, value) => {
        setFormData((prevData) => {
            const updatedMedicines = [...prevData.CreatePrescriptionDetailsDTO];
            updatedMedicines[index][field] = value;
            return {
                ...prevData,
                CreatePrescriptionDetailsDTO: updatedMedicines
            };
        });
    };

    return (<>
    <h1 style={{ textAlign: 'center', margin: 10 }}>prescription</h1>

        <div style={centerDivStyle}>
            
            <div style={{width:500}}>
            <ul>
                {formData.CreatePrescriptionDetailsDTO.map((CreatePrescriptionDetailsDTO, index) => (
                    <li>
                        {/* medicine
                        <input
                            type="text"
                            value={CreatePrescriptionDetailsDTO.m_id}
                            onChange={(e) => handleMedicineChange(index, 'm_id', e.target.value)}
                            placeholder="m_id"
                        /> */}
                        

                                  <div className="row">
                                   
                                            <p className="form-label">Medicine</p>
                                            <select className="form-select" aria-label="Default select example" name="m_id"  onChange={(e) => handleMedicineChange(index, 'm_id', e.target.value)}>
                                           
                                               
                                               
                                                <option value={"default"}>
                                                    Select Medicine
                                                </option>
                                                {
                                                    medicine.map(medicine => {
                                                        return <option value={medicine.id} key={medicine.id}>
                                                            {medicine.name}
                                                        </option>
                                                        

                                                        
                                                    })
                                                }
                                            </select>
                                        </div>
                                  
                        
                       
                         
                        <div className="row">
                                   
                                   <p className="form-label">Quantity</p>
                        {/* <input
                            type="text"
                            value={CreatePrescriptionDetailsDTO.quantity}
                            onChange={(e) => handleMedicineChange(index, 'quantity', parseInt(e.target.value))}
                            placeholder="Quantity"
                        /> */}

                            <input
                            type="text"
                            value={CreatePrescriptionDetailsDTO.quantity}
                            onChange={(e) => handleMedicineChange(index, 'quantity', e.target.value)}
                            placeholder="ho ja bhai"
                        />
                        </div>
                      
                        <div className="row">
                                   
                                   <p className="form-label">Dosage</p>                        <input
                            type="text"
                            value={CreatePrescriptionDetailsDTO.dosage}
                            onChange={(e) => handleMedicineChange(index, 'dosage', e.target.value)}
                            placeholder="Dosage"
                        />
                        </div>
                         
                         <div className="row">
                                   
                                   <p className="form-label">Duration</p>
                        <input
                            type="text"
                            value={CreatePrescriptionDetailsDTO.duration}
                            onChange={(e) => handleMedicineChange(index, 'duration', e.target.value)}
                            placeholder="Duration"
                        />
                                                </div>

                <br></br>
                <br></br>
                    </li>
                ))}
            </ul>
            <button style={{width:200}} className="btn btn-info" onClick={addMedicine}>Add Medicine</button>
            <button style={{width:200}} className="btn btn-success" onClick={Submit}>submit</button>


            </div>
        </div>
        </>
    );
}

export default DoctorPrescription;