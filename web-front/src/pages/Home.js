import "./CSS/Home.css";
import {Link, useNavigate, useLocation} from "react-router-dom";
import {useForm} from "react-hook-form";
import axios from "axios";
import React, {useEffect, useState} from "react";


const Home = () => {
    let s;
    const navigate = useNavigate();
    const [transaction, setTransaction] = useState([]);
    useEffect(() => {
        transData();
    }, []);
 const location = new useLocation();
    const transData = async () => {
        const {data} = await axios.get(`http://localhost:9090/users/${location.data.id}/transactions`);
        setTransaction(data);
    };

    return (
        <div className={"row form-box"}>
            <div className={"container"}>
                <div className={"table-box card"}>
                    <div className={"table-header"}>
                        <h1 className={"table-title mt-3"}>
                            Current Balance
                        </h1>
                    </div>
                    <div className={"card-body"}>
                        <table className="table">
                            <thead className="thead-dark table-head">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col" data-sortable="true" data-sorter="alphanum">Transaction Type</th>
                                <th scope="col" data-sortable="true" data-sorter="alphanum">Date</th>
                                <th scope="col" data-sortable="true" data-sorter="alphanum">Amount (Rs)</th>
                                <th scope="col" data-sortable="true" data-sorter="alphanum">Post Balance (Rs)</th>
                                <th scope="col" data-sortable="true" data-sorter="alphanum">Description</th>
                            </tr>
                            </thead>
                            <tbody>
                            {transaction.map((data, i) => (
                            <tr  obj={data} key={i}>

                                    <>
                                        <th scope="row">{i}</th>
                                        <td>{data.transactionType}</td>
                                        <td>{ s = new Date(data.timestamp).toLocaleDateString("en-US")}</td>
                                        <td>{data.amount}</td>
                                        <td>{data.postBalance}</td>
                                        <td>{data.description}</td>
                                    </>

                            </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    );
}
export default Home;
