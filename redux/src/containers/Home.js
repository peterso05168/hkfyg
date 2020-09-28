import { connect } from 'react-redux';
import actions from '../actions';
// import TheComponent from '../components/public/home/home';
import React, { Component } from "react";
import ReactTable from "react-table";
const mapStateToProps = (state, ownProps) => {
    return {
     
    }
}
const mapDispatchToProps = (dispatch, ownProps) => {
    return {
       
    }
}

class TheComponent extends React.Component {
    render() {
        // const data = React.useMemo(
        //     () => [
        //         {
        //             col1: "",
        //             col2: "24/09/2020 (四)",
        //             col3: "25/09/2020 (五)",
        //             col4: "26/09/2020 (六)",
        //             col5: "27/09/2020 (日)",
        //             col6: "28/09/2020 (一)",
        //             col7: "29/09/2020 (二)",
        //             col8: "30/09/2020 (三)",
        //         },
        //         {
        //             col1: "日營",
        //             col2: "尚餘250位",
        //             col3: "尚餘250位",
        //             col4: "尚餘250位",
        //             col5: "尚餘250位",
        //             col6: "尚餘250位",
        //             col7: "尚餘250位",
        //             col8: "尚餘250位",
        //         },
        //         {
        //             col1: "黃昏營",
        //             col2: "尚餘250位",
        //             col3: "尚餘250位",
        //             col4: "尚餘250位",
        //             col5: "尚餘250位",
        //             col6: "尚餘250位",
        //             col7: "尚餘250位",
        //             col8: "尚餘250位",
        //         },
        //         {
        //             col1: "28 人複式客房",
        //             col2: "尚餘2間",
        //             col3: "尚餘2間",
        //             col4: "尚餘2間",
        //             col5: "尚餘2間",
        //             col6: "尚餘2間",
        //             col7: "尚餘2間",
        //             col8: "尚餘2間",
        //         }
        //     ]
        // )

        // const columns = React.useMemo(
        //     () => [
        //         {
        //             Header: '',
        //             accessor: 'col1',
        //         },
        //         {
        //             Header: 'Column 2',
        //             accessor: 'col2',
        //         },
        //         {
        //             Header: 'Column 1',
        //             accessor: 'col3',
        //         },
        //         {
        //             Header: 'Column 2',
        //             accessor: 'col4',
        //         },
        //         {
        //             Header: 'Column 1',
        //             accessor: 'col5',
        //         },
        //         {
        //             Header: 'Column 2',
        //             accessor: 'col6',
        //         },
        //         {
        //             Header: 'Column 1',
        //             accessor: 'col7',
        //         },
        //         {
        //             Header: 'Column 2',
        //             accessor: 'col8',
        //         },
        //     ],
        //     []
        // )

        // function Table({ columns, data }) {
        //     // Use the state and functions returned from useTable to build your UI
        //     const {
        //         getTableProps,
        //         getTableBodyProps,
        //         headerGroups,
        //         rows,
        //         prepareRow,
        //     } = useTable({
        //         columns,
        //         data,
        //     })

        //     // Render the UI for your table
        //     return (
        //         <table {...getTableProps()}>
        //             <thead>
        //                 {headerGroups.map(headerGroup => (
        //                     <tr {...headerGroup.getHeaderGroupProps()}>
        //                         {headerGroup.headers.map(column => (
        //                             <th {...column.getHeaderProps()}>{column.render('Header')}</th>
        //                         ))}
        //                     </tr>
        //                 ))}
        //             </thead>
        //             <tbody {...getTableBodyProps()}>
        //                 {rows.map((row, i) => {
        //                     prepareRow(row)
        //                     return (
        //                         <tr {...row.getRowProps()}>
        //                             {row.cells.map(cell => {
        //                                 return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
        //                             })}
        //                         </tr>
        //                     )
        //                 })}
        //             </tbody>
        //         </table>
        //     )
        // }
        return (
            //     <div className="">
            //     <p>	網上只可查詢15個月內的營位，如查詢往後日子營位，請致電27922727</p>
            //     <div className="tableContainer layout">
            //     <Table columns={columns} data={data} />
            //     </div>
            // </div>
            <div className="ui container">
                <br />
                <strong>Shipment Details</strong>
                <br />
                <br />
                <ReactTable
                    data={[
                        {
                            col1: "",
                            col2: "24/09/2020 (四)",
                            col3: "25/09/2020 (五)",
                            col4: "26/09/2020 (六)",
                            col5: "27/09/2020 (日)",
                            col6: "28/09/2020 (一)",
                            col7: "29/09/2020 (二)",
                            col8: "30/09/2020 (三)",
                        },
                        {
                            col1: "日營",
                            col2: "尚餘250位",
                            col3: "尚餘250位",
                            col4: "尚餘250位",
                            col5: "尚餘250位",
                            col6: "尚餘250位",
                            col7: "尚餘250位",
                            col8: "尚餘250位",
                        },
                        {
                            col1: "黃昏營",
                            col2: "尚餘250位",
                            col3: "尚餘250位",
                            col4: "尚餘250位",
                            col5: "尚餘250位",
                            col6: "尚餘250位",
                            col7: "尚餘250位",
                            col8: "尚餘250位",
                        },
                        {
                            col1: "28 人複式客房",
                            col2: "尚餘2間",
                            col3: "尚餘2間",
                            col4: "尚餘2間",
                            col5: "尚餘2間",
                            col6: "尚餘2間",
                            col7: "尚餘2間",
                            col8: "尚餘2間",
                        }
                    ]}
                    filterable
                    defaultFilterMethod={(filter, row) =>
                        String(row[filter.id]).toLowerCase().indexOf(filter.value.toLowerCase()) > -1}
                    columns={[
                        {
                            Header: '',
                            accessor: 'col1',
                        },
                        {
                            Header: 'Column 2',
                            accessor: 'col2',
                        },
                        {
                            Header: 'Column 1',
                            accessor: 'col3',
                        },
                        {
                            Header: 'Column 2',
                            accessor: 'col4',
                        },
                        {
                            Header: 'Column 1',
                            accessor: 'col5',
                        },
                        {
                            Header: 'Column 2',
                            accessor: 'col6',
                        },
                        {
                            Header: 'Column 1',
                            accessor: 'col7',
                        },
                        {
                            Header: 'Column 2',
                            accessor: 'col8',
                        },
                    ]}
                    defaultPageSize={20}
                    className="-striped -highlight"
                />
                <br />
            </div>
        )
    }
}


const Home = connect(
    mapStateToProps,
    mapDispatchToProps
)(TheComponent)
export default Home;