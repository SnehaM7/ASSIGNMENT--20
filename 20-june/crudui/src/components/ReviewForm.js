import { useEffect, useState } from "react"
import { getAllProducts } from "../services/ProductService";
import { saveReview } from "../services/ReviewService";

export function ReviewForm(){
    const [productsList, setProductsList] = useState([]);
    const [formData, setFormData] = useState({content:'',reviewGivenBy:''});
    const [selectedProductId,setSelectedProductId] = useState(0);
    async function fetchProducts(){
        try {
            const response = await getAllProducts();
            if(response.status === 200){
                console.log(response.data.products);
                setProductsList(response.data.products); 
                setSelectedProductId(response.data.products[0].id);
            }
              
        } catch (error) {
            
            if(error.response.status === 404){
                console.log(error);
                setProductsList([]);
                   
            }
        }
       
    }

    useEffect(()=>{
        fetchProducts();
    },[]);

    const handleInputChange = (e)=>{
        setFormData({...formData,[e.target.name]:e.target.value});
    }

    const handleSelectChange = (e)=>{
        setSelectedProductId(e.target.value);
    }

    const handleSubmit = async(e)=>{
        e.preventDefault();
       const response = await saveReview(selectedProductId, formData);
       console.log(response);
    }
    return (

        <div>
            <form onSubmit={handleSubmit}>
                {
                    productsList.length!==0 ? 
                    <select name="productId" onChange={handleSelectChange}>
                        {
                            productsList.map((product)=>{
                                return (
                                    <option value={product.id}>{product.name}</option>
                                )
                            })
                        }
                    </select> : <h5>No products available</h5>
                }
                
                <textarea name="content" placeholder="Review" onChange={handleInputChange}></textarea>
                <input type="text" name="reviewGivenBy" placeholder="enter your name" onChange={handleInputChange}></input>
                <input type="submit" value="Post Review" disabled={productsList.length==0}></input>
            </form>
        </div>
    )
}